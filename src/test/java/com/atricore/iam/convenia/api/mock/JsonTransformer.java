package com.atricore.iam.convenia.api.mock;

import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ResponseTransformer;

public class JsonTransformer implements ResponseTransformer {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String render(Object model) throws Exception {
        return objectMapper.writeValueAsString(model);
    }
}
