package com.gy.monitorCore.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by gy on 2018/10/14.
 */
@Getter
@Setter
public class K8scMonitorInfo {

    @JsonProperty("master_ip")
    private String masterIp;

    @JsonProperty("api_port")
    private String apiPort;

    @JsonProperty("cadvisor_port")
    private String cadvisorPort;

    @JsonProperty("node_ip")
    private String nodeIp;

    @JsonProperty("container_id")
    private String containerId;

    @JsonProperty("pod_name")
    private String podName;

    @JsonProperty("pod_namespace")
    private String podNamespace;

}
