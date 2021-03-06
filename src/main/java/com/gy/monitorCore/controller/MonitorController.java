package com.gy.monitorCore.controller;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gy.monitorCore.entity.*;
import com.gy.monitorCore.entity.view.DbAccessView;
import com.gy.monitorCore.entity.view.K8sAccessView;
import com.gy.monitorCore.entity.view.TomcatAccessView;
import com.gy.monitorCore.service.MonitorService;
import org.json.JSONString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * Created by gy on 2018/3/31.
 */
@RestController
@RequestMapping("monitor")
public class MonitorController {

    @Autowired
    private MonitorService service;

    @Autowired
    private ObjectMapper mapper;

    @RequestMapping("jpa")
    @ResponseBody
    public TestEntity testJPA(HttpServletRequest request){
//        TestEntity entity = new TestEntity();
//        entity.setId("sasada");
//        entity.setName("gygy");
//        return entity;
        return service.getJPAInfo();
    }

//
//    @RequestMapping("getMonitorRecord")
//    @ResponseBody
//    public String getOperationMonitorEntity(String uuid) throws Exception {
////        return service.getOperationMonitorEntity(uuid);
//                return mapper.writeValueAsString(service.getOperationMonitorEntity(uuid));
//    }

    @RequestMapping("getMonitorRecord")
    @ResponseBody
    public String getOperationMonitorEntity(String uuid,String lightType) throws Exception {
//        return service.getOperationMonitorEntity(uuid);
        return service.getOperationMonitorEntity(uuid,lightType);
    }

    @RequestMapping("getNetworkMonitorRecord")
    @ResponseBody
    public String getNetworkMonitorEntity(String uuid) throws Exception {
        return mapper.writeValueAsString(service.getNetworkMonitorEntity(uuid));
    }


//    @RequestMapping("getAllMonitorRecord")
//    @ResponseBody
//    public String getAllOperationMonitorEntity() throws Exception {
////        return service.getOperationMonitorEntity(uuid);
//        return mapper.writeValueAsString(service.getAllOperationMonitorEntity());
//    }


//    @RequestMapping("getMiddleType")
//    @ResponseBody
//    public String getMiddleTypeEntity() throws Exception {
//        return mapper.writeValueAsString(service.getMiddleTypeEntity());
//    }
//
//    @RequestMapping("getLightType")
//    @ResponseBody
//    public String getLightTypeEntity() throws Exception {
//        return mapper.writeValueAsString(service.getLightTypeEntity());
//    }

//    @RequestMapping("addMonitorRecord")
//    @ResponseBody
//    public boolean insertMonitorRecord(@RequestBody String data) throws IOException {
//        OperationMonitorEntity view = mapper.readValue(data,OperationMonitorEntity.class);
//        return service.insertMonitorRecord(view);
//    }


    @RequestMapping("addMonitorRecord")
    @ResponseBody
    public boolean insertMonitorRecord(@RequestBody String data,String lightType) throws IOException {
        return service.insertMonitorRecord(data,lightType);
    }



    //不再插入cluster
//    @RequestMapping("getClusterList")
//    @ResponseBody
//    public String getClusterListByExporter(@RequestBody String data) throws Exception {
//        CasTransExporterModel model = mapper.readValue(data,CasTransExporterModel.class);
//        return mapper.writeValueAsString(service.getClusterListByExporter(model));
//    }

//    @RequestMapping("addMonitorRecordList")
//    @ResponseBody
//    public boolean insertMonitorRecordList(@RequestBody String data) throws IOException {
//
//        List<OperationMonitorEntity> list = mapper.readValue(data,new TypeReference<List<OperationMonitorEntity>>(){});
//        return service.insertMonitorRecordList(list);
//    }

    @RequestMapping("addMonitorRecordList")
    @ResponseBody
    public boolean insertMonitorRecordList(@RequestBody String data,String lightType) throws IOException {
        return service.insertMonitorRecordList(data,lightType);
    }



    @RequestMapping("getCvkAndVmList")
    @ResponseBody
    public String getCvkAndVmListByExporter(@RequestBody String data) throws Exception {
        CasTransExporterModel model = mapper.readValue(data,CasTransExporterModel.class);
        return mapper.writeValueAsString(service.getCvkAndVmListByExporter(model));
    }

    @RequestMapping("getContainerList")
    @ResponseBody
    public String getContainerListByExporter(String ip,String port) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getContainerListByExporter(ip,port));
    }
    @RequestMapping("getNodeList")
    @ResponseBody
    public String getNodeListByExporter(String ip,String port) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getNodeListByExporter(ip,port));
    }

//    @RequestMapping("/delNetworkMonitorRecord")
//    @ResponseBody
//    public boolean delMonitorRecord(String uuid){
//        return service.delMonitorRecord(uuid);
//    }

    @RequestMapping("/delNetworkMonitorRecord")
    @ResponseBody
    public boolean delMonitorRecord(String uuid,String lightType){
        return service.delMonitorRecord(uuid,lightType);
    }


    @RequestMapping("getMonitorRecordByRootId")
    @ResponseBody
    public String getMonitorRecordByRootId(String uuid) throws Exception {
        return mapper.writeValueAsString(service.getMonitorRecordByRootId(uuid));
    }

//    @RequestMapping("getMonitorRecordByTemplateId")
//    @ResponseBody
//    public String getMonitorRecordByTemplateId(String uuid) throws Exception {
//        return mapper.writeValueAsString(service.getMonitorRecordByTemplateId(uuid));
//    }

    @RequestMapping("getMonitorRecordByTemplateId")
    @ResponseBody
    public String getMonitorRecordByTemplateId(String uuid,String lightType) throws Exception {
        return service.getMonitorRecordByTemplateId(uuid,lightType);
    }

    @RequestMapping("getClusterIP")
    @ResponseBody
    public String testgetClusterIp() throws Exception {
        return service.testgetClusterIp();
    }

    @RequestMapping("getQuotaValueByName")
    @ResponseBody
    public String getQuotaValueByName(String monitorUUid,String quotaName) throws IOException {
        return service.getQuotaValueByName(monitorUUid,quotaName);
    }

    @RequestMapping("getAllNetworkMonitorRecord")
    @ResponseBody
    public String getAllNetworkMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllNetworkMonitorEntity());
    }



    @RequestMapping("getAllTomcatMonitorRecord")
    @ResponseBody
    public String getAllTomcatMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllTomcatMonitorEntity());
    }


    @RequestMapping("getAllDbMonitorRecord")
    @ResponseBody
    public String getAllDbMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllDbMonitorEntity());
    }


    @RequestMapping("getAllCasMonitorRecord")
    @ResponseBody
    public String getAllCasMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllCasMonitorEntity());
    }


    @RequestMapping("getAllHostMonitorRecord")
    @ResponseBody
    public String getAllHostMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllHostMonitorEntity());
    }


    @RequestMapping("getAllVmMonitorRecord")
    @ResponseBody
    public String getAllVmMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllVmMonitorEntity());
    }


    @RequestMapping("getAllK8sMonitorRecord")
    @ResponseBody
    public String getAllK8sMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllK8sMonitorEntity());
    }



    @RequestMapping("getAllK8snodeMonitorRecord")
    @ResponseBody
    public String getAllK8snodeMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllK8snodeMonitorEntity());
    }



    @RequestMapping("getAllK8scontainerMonitorRecord")
    @ResponseBody
    public String getAllK8sContainerMonitorEntity() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllK8sContainerMonitorEntity());
    }

    @RequestMapping("getAllNodeAndContainerByK8suuid")
    @ResponseBody
    public String getAllNodeAndContainerByK8suuid(String uuid) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllNodeAndContainerByK8suuid(uuid));
    }
    @RequestMapping("getAllContainerByK8sNodeuuid")
    @ResponseBody
    public String getAllContainerByK8sNodeuuid(String uuid) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllContainerByK8sNodeuuid(uuid));
    }


    @RequestMapping("getAllCvkAndVmByCasuuid")
    @ResponseBody
    public String getAllCvkAndVmByCasuuid(String uuid) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllCvkAndVmByCasuuid(uuid));
    }

    @RequestMapping("getAllVmByCvkuuid")
    @ResponseBody
    public String getAllVmByCvkuuid(String uuid) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getAllVmByCvkuuid(uuid));
    }

    @RequestMapping("getExporterLldpInfo")
    @ResponseBody
    public String getExporterLldpInfo() throws JsonProcessingException {
        return mapper.writeValueAsString(service.getExporterLldpInfo());
    }

    @RequestMapping("getExporterInterfaceInfo")
    @ResponseBody
    public String getExporterInterfaceInfo(String monitorUuid) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getExporterInterfaceInfo(monitorUuid));
    }

    @RequestMapping("isMonitorRecordIpDup")
    @ResponseBody
    public boolean isMonitorRecordIpDup(String ip,String lightType){
        return service.isMonitorRecordIpDup(ip,lightType);
    }
    @RequestMapping("isMonitorRecordIpDupNotP")
    @ResponseBody
    public boolean isMonitorRecordIpDupNotP(String ip,String lightType,String uuid){
        return service.isMonitorRecordIpDupNotP(ip,lightType,uuid);
    }

    @RequestMapping("getInterfaceRate")
    @ResponseBody
    public String getInterfaceRate(String monitorUuid,String quotaName) throws JsonProcessingException {
        return mapper.writeValueAsString(service.getInterfaceRate(monitorUuid,quotaName));
    }
    @RequestMapping("getBusMonitorListByPage")
    @ResponseBody
    public String getBusMonitorListByPage(@RequestBody String data) throws IOException {
        PageData view = mapper.readValue(data, PageData.class);
        return mapper.writeValueAsString(service.getBusMonitorListByPage(view));
    }


    @RequestMapping("dbCanAccess")
    @ResponseBody
    public String dbCanAccess(@RequestBody String data) throws IOException {
        DbAccessView view = mapper.readValue(data, DbAccessView.class);
        return mapper.writeValueAsString(service.dbCanAccess(view));
    }
    @RequestMapping("k8sCanAccess")
    @ResponseBody
    public String k8sCanAccess(@RequestBody String data) throws IOException {
        K8sAccessView view = mapper.readValue(data, K8sAccessView.class);
        return mapper.writeValueAsString(service.k8sCanAccess(view));
    }
    @RequestMapping("tomcatCanAccess")
    @ResponseBody
    public String tomcatCanAccess(@RequestBody String data) throws IOException {
        TomcatAccessView view = mapper.readValue(data, TomcatAccessView.class);
        return mapper.writeValueAsString(service.TomcatAccessView(view));
    }

}
