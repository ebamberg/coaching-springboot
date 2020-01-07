package com.ebamberg.coaching.demos.springdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartupHook {

    private @Autowired List<RunOnStartup> runonstartups;

   @EventListener
    public void handleContextRefreshedEvent(ContextRefreshedEvent ctxSRefreshEvt) {
       runonstartups.forEach( RunOnStartup::execute);
    }

}