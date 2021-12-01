/**
 * GetInsurancesResponse_returnEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.home.restful.controller;

public class GetInsurancesResponse_returnEntry  implements java.io.Serializable {
    private java.lang.Integer key;

    private com.home.restful.controller.Insurance value;

    public GetInsurancesResponse_returnEntry() {
    }

    public GetInsurancesResponse_returnEntry(
           java.lang.Integer key,
           com.home.restful.controller.Insurance value) {
           this.key = key;
           this.value = value;
    }


    /**
     * Gets the key value for this GetInsurancesResponse_returnEntry.
     * 
     * @return key
     */
    public java.lang.Integer getKey() {
        return key;
    }


    /**
     * Sets the key value for this GetInsurancesResponse_returnEntry.
     * 
     * @param key
     */
    public void setKey(java.lang.Integer key) {
        this.key = key;
    }


    /**
     * Gets the value value for this GetInsurancesResponse_returnEntry.
     * 
     * @return value
     */
    public com.home.restful.controller.Insurance getValue() {
        return value;
    }


    /**
     * Sets the value value for this GetInsurancesResponse_returnEntry.
     * 
     * @param value
     */
    public void setValue(com.home.restful.controller.Insurance value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetInsurancesResponse_returnEntry)) return false;
        GetInsurancesResponse_returnEntry other = (GetInsurancesResponse_returnEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetInsurancesResponse_returnEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controller.restful.home.com/", ">>getInsurancesResponse>_return>entry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://controller.restful.home.com/", "insurance"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
