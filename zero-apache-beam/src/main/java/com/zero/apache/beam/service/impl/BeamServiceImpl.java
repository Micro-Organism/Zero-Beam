package com.zero.apache.beam.service.impl;

import com.zero.apache.beam.service.BeamService;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BeamServiceImpl implements BeamService {

    @Override
    public void runPipeline(Pipeline pipeline) {
        PCollection<String> input = pipeline.apply("ReadLines", TextIO.read().from("input.txt"));
        PCollection<String> output = input.apply("TransformData", ParDo.of(new UppercaseFn()));

        output.apply("WriteLines", TextIO.write().to("output.txt"));
        pipeline.run().waitUntilFinish();
    }

    static class UppercaseFn extends DoFn<String, String> {
        @ProcessElement
        public void processElement(ProcessContext c) {
            c.output(Objects.requireNonNull(c.element()).toUpperCase());
        }
    }

}
