package org.moomoocow.trading;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.moomoocow.trading.tws.TwsMain;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ib.client.Contract;

@SpringBootApplication
public class Application  implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private InstrumentRepository instrumentRepository;

	@Autowired
	private PriceRepository priceRepository;

	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}


	private void savePrices(List<Price> prices) {
		prices.forEach(this::savePrice);
	}
	
	private void savePrice(Price price) {
		try{
			priceRepository.save(price);
		}
		catch(Exception e){
			LOG.warn("Can't save price=" + price,e);
		}		
	}

	private void savePositions(List<Position> ps) {
		ps.forEach(this::savePosition);
	}
		
	private void savePosition(Position pos) {
		try{
			positionRepository.save(pos);
		}
		catch(Exception e){
			LOG.warn("Cant save pos=" + pos,e);
		}		
	}	

	private void saveInstruments(List<Instrument> cs) {
		cs.forEach(this::saveInstrument);
	}	
	
	private void saveInstrument(Instrument c) {
		try{
			instrumentRepository.save(c);
		}
		catch(Exception e){
			LOG.warn("Cant save instrument=" + c,e);
		}		
	}	
	
	
	@Override
	public void run(String... arg0) throws Exception {
		TwsMain m = new TwsMain();
		List<Position> positions = m.getPositions();

		List<Instrument> instruments = positions.stream().map(p -> p.getInstrument())
				.collect(Collectors.toList());
		
		saveInstruments(instruments);

		Date now = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
		positions.stream().forEach(p->p.setDate(now));
		
		savePositions(positions);
		
		
		positions.stream().forEach( p -> { 
			Contract c = p.getOrigContract();
			Instrument instrument = p.getInstrument();
			List<Price> prices = m.getHistoricalData(instrument, c);
			savePrices(prices);
		});
		
		m.get
		

		System.exit(0);
	};		
}