package com.amazon.ata.dynamodbscanandserialization.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Handles the serialization and deserialization of Order object.
 */
public class OrderSerializer {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * Deserializes the json string to an Order object.
     * @param json string representing an Order object
     * @return an Order object instantiated by the json provided
     * @throws OrderSerializationException if the provided JSON cannot be deserialized to an Order object
     */
    public static Order toOrder(String json) {
        // TODO: implement
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Order.class);
        } catch (IOException e) {
            throw new OrderSerializationException("Failed to Deserilize Json", e);        }
    }

    /**
     * Serializes the provided Order as a string in JSON.
     * @param order the order to serialize
     * @return the order in JSON format
     * @throws OrderSerializationException if the order cannot be written to JSON
     */
    public static String toJSON(Order order) {
        // TODO: implement
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(order);
        }catch (JsonProcessingException e) {
            throw new OrderSerializationException("Failed to serialize JSON", e);
        }


    }
}
