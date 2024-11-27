package com.zero.apache.beam.common.config;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeamConfig {

    @Bean
    public Pipeline getPipeline() {
        // 一个简单的 Beam Pipeline 示例
        Pipeline pipeline = Pipeline.create();
        pipeline.apply(TextIO.read().from("input.txt"))
                .apply(TextIO.write().to("output.txt"));
        pipeline.run().waitUntilFinish();
        return pipeline;
    }

}
