package me.developery.acturator_study.timer;

import io.micrometer.core.instrument.FunctionTimer;
import io.micrometer.core.instrument.MeterRegistry;
import me.developery.acturator_study.timer.MyTimerManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class FunctionTimerConfig {

    @Bean
    FunctionTimer myFunctionTimer(MeterRegistry meterRegistry, MyTimerManager myTimerManager) {
        FunctionTimer functionTimer = FunctionTimer.builder("my.timer5.latency", myTimerManager,
                        m -> {
                            return m.getCount();
                        },
                        m -> {
                            return m.getTotalTime();
                        },
                        TimeUnit.SECONDS)
                .register(meterRegistry);

        return functionTimer;
    }
}