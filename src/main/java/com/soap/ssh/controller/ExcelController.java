package com.soap.ssh.controller;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 学习excel文件上传和解析
 */
@Controller
@RequestMapping("excel")
public class ExcelController {

    @PostMapping("upload")
    @ResponseBody
    public String uploadExcel( @RequestParam("file") MultipartFile file){
        String fileName = file.getOriginalFilename();
        if(StringUtils.isEmpty(fileName)){
            return "文件不能为空！";
        }
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        if(!prefix.toLowerCase().contains("xls")&&prefix.toLowerCase().contains("xlsx")){
            return "文件格式异常，请重新上传Excel文件格式！";
        }
        Workbook workbook=null;
        File excelFile= null;
        try {
            excelFile = File.createTempFile(System.currentTimeMillis()+"",prefix);
            file.transferTo(excelFile);
            boolean isExcel2003=prefix.toLowerCase().endsWith("xls")?true:false;
            if(isExcel2003){
                workbook = new HSSFWorkbook(new FileInputStream(excelFile));
            }else {
                workbook = new XSSFWorkbook(new FileInputStream(excelFile));
            }
        }catch (Exception e){

        }
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Sheet sheet = workbook.getSheetAt(0);
        //从1开始，跳过标题，直接从第二行开始解析
        for (int i=1;i<sheet.getLastRowNum()+1;i++){
            Row row = sheet.getRow(i);
            //id
            if(row.getCell(0)!=null){
                row.getCell(0).setCellType(CellType.STRING);
            }
            //username
            if(row.getCell(1)!=null){
                row.getCell(1).setCellType(CellType.STRING);
            }
            //age
            if(row.getCell(2)!=null){
                row.getCell(2).setCellType(CellType.NUMERIC);
            }
            //money
            if(row.getCell(3)!=null){
                row.getCell(3).setCellType(CellType.NUMERIC);
            }
            //时间
            if(row.getCell(4)!=null){
                row.getCell(4).setCellType(CellType.STRING);
            }
            //phone
            if(row.getCell(5)!=null){
                row.getCell(5).setCellType(CellType.STRING);
            }
            //address
            if(row.getCell(6)!=null){
                row.getCell(6).setCellType(CellType.STRING);
            }
            //remark
            if(row.getCell(7)!=null){
                row.getCell(7).setCellType(CellType.STRING);
            }
            //验证
            String username = row.getCell(1).getStringCellValue();
            if(StringUtils.isEmpty(username)){
                return "第" + i+"行，第2列username不能为空!";
            }
            //组装列表
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("id",row.getCell(0).getStringCellValue());
            map.put("username",row.getCell(1).getStringCellValue());
            map.put("age",row.getCell(2).getNumericCellValue());
            map.put("money",row.getCell(3).getNumericCellValue());
//            String stringCellValue = row.getCell(4).getStringCellValue();
//            map.put("create", ExcelDateUtil.formatDate(stringCellValue));
            map.put("phone",row.getCell(5).getStringCellValue());
            map.put("address",row.getCell(6).getStringCellValue());
            map.put("remark",row.getCell(7).getStringCellValue());
            list.add(map);
        }
        //删除临时转换的文件
        if (excelFile.exists()) {
            excelFile.delete();
        }
        //list就是具体内容，剩下的就是自己处理具体业务了
        System.out.println("上传的内容就是这个了：" + list);
        return "success";
    }
}
