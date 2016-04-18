package com.apress.isf.java.utils;

import com.thoughtworks.xstream.XStream;

/**
 * Created by nishi on 2016-04-04.
 */
public class XmlUtils {

    public static <T> String toXml(T object) {
        XStream xStream = new XStream();
        xStream.alias(object.getClass().getSimpleName().toLowerCase(), object.getClass());
        return xStream.toXML(object);
    }

    @SuppressWarnings({"unchecked"})
    public static <T> T fromXML(String xml, Class<T> _class) {
        XStream xStream = new XStream();
        xStream.alias(_class.getSimpleName().toLowerCase(), _class);
        return (T)xStream.fromXML(xml);
    }
}
