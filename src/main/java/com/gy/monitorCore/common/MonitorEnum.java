package com.gy.monitorCore.common;

/**
 * Created by gy on 2018/6/8.
 */
public interface MonitorEnum {

    enum MonitorRecordEnum {
        SNMP_VERSION_V1("snmp_v1"),
        SNMP_VERSION_V2("snmp_v2c");


        private String value;

        MonitorRecordEnum(String msg) {
            this.value = msg;
        }

        public String value() {
            return this.value;
        }
    }
    enum MonitorTypeEnum{
        SNMP("snmp"),

        MYSQL("mysql"),

        TOMCAT("tomcat"),

        CAS("cas"),

        CASCLUSTER("cascluster"),

        CVK("cas_cvk"),

        VIRTUALMACHINE("cas_vm"),

        K8S("k8s"),

        K8SNODE("k8sn"),

        K8SCONTAINER("k8sc");

        private String value;

        MonitorTypeEnum(String msg) {
            this.value = msg;
        }

        public String value() {
            return this.value;
        }
    }

    enum LightTypeEnum{

        SWITCH("switch"),

        ROUTER("router"),

        LB("LB"),

        FIREWALL("firewall"),

        MYSQL("MySQL"),

        TOMCAT("Tomcat"),

        CAS("CAS"),

        CASCLUSTER("CASCluster"),

        CVK("CVK"),

        VIRTUALMACHINE("VirtualMachine"),

        K8S("k8s"),

        K8SNODE("k8sNode"),

        K8SCONTAINER("k8sContainer");

        private String value;

        LightTypeEnum(String msg) {
            this.value = msg;
        }

        public String value() {
            return this.value;
        }
    }

}
