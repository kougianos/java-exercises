package com.javaexercices.kougianos.util;

import org.json.JSONObject;
import org.json.XML;

public class ConvertUtils {

    private ConvertUtils() {

    }

    /**
     * Convert XML string to JSON string using org.json library.
     *
     * @param xml input xml string
     * @return json string
     */
    public static String xmlToJsonString(String xml) {
        return XML.toJSONObject(xml).toString();
    }

    /**
     * Convert Json string to XML string using org.json library.
     *
     * @param json input json string
     * @return xml string
     */
    public static String jsonToXmlString(String json) {
        JSONObject jsonObject = new JSONObject(json);
        return XML.toString(jsonObject, "xml-root-node");
    }

}
