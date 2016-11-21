package org.moomoocow.trading.tws;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ib.client.EWrapper;

@Service
public class EWrapHandler implements InvocationHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(EWrapHandler.class);

  private final List<EWrapper> wrappers;

  public EWrapHandler() {
    this.wrappers = new ArrayList<>();
  }

  public void addWrap(EWrapper wrap) {
    LOGGER.info("addWrap={}", wrap);
    this.wrappers.add(wrap);
  }


  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    // LOGGER.info("invoke={}", method.getName());
    this.wrappers.forEach(c -> {
      try {
        method.invoke(c, args);
      } catch (final Exception e) {
        e.printStackTrace();
      }
    });
    return null;
  }

}
