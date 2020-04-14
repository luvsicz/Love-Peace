package org.dev.hrm.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.dev.hrm.model.Employee;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

/**
 * @author 冷嘉贤
 * @version 1.0.0
 * @ClassName POIUtils.java
 * @createTime 2020年03月23日 16:53:00
 */
public class POIUtils {

  private POIUtils() {
  }

  /**
   * 员工集合转换成Excel
   *
   * @param list
   * @return
   */
  public static ResponseEntity<byte[]> employee2Excel(List<Employee> list) {
    //1. 创建一个 Excel 文档
    HSSFWorkbook workbook = new HSSFWorkbook();
    //2. 创建文档摘要
    workbook.createInformationProperties();
    //3. 获取并配置文档信息
    DocumentSummaryInformation docInfo = workbook
        .getDocumentSummaryInformation();
    //文档类别
    docInfo.setCategory("员工信息");
    //文档管理员
    docInfo.setManager("admin");
    //设置公司信息
    docInfo.setCompany("Company");
    //4. 获取文档摘要信息
    SummaryInformation summInfo = workbook.getSummaryInformation();
    //文档标题
    summInfo.setTitle("员工信息表");
    //文档作者
    summInfo.setAuthor("admin");
    // 文档备注
    summInfo.setComments("本文档由POI组装");
    //5. 创建样式
    //创建标题行的样式
    HSSFCellStyle headerStyle = workbook.createCellStyle();
    headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    HSSFCellStyle dateCellStyle = workbook.createCellStyle();
    dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
    HSSFSheet sheet = workbook.createSheet("员工信息表");
    //设置列的宽度
    sheet.setColumnWidth(0, 5 * 256);
    sheet.setColumnWidth(1, 12 * 256);
    sheet.setColumnWidth(2, 10 * 256);
    sheet.setColumnWidth(3, 5 * 256);
    sheet.setColumnWidth(4, 12 * 256);
    sheet.setColumnWidth(5, 20 * 256);
    sheet.setColumnWidth(6, 10 * 256);
    sheet.setColumnWidth(7, 10 * 256);
    sheet.setColumnWidth(8, 16 * 256);
    sheet.setColumnWidth(9, 12 * 256);
    sheet.setColumnWidth(10, 15 * 256);
    sheet.setColumnWidth(11, 20 * 256);
    sheet.setColumnWidth(12, 16 * 256);
    sheet.setColumnWidth(13, 14 * 256);
    sheet.setColumnWidth(14, 14 * 256);
    sheet.setColumnWidth(15, 12 * 256);
    sheet.setColumnWidth(16, 8 * 256);
    sheet.setColumnWidth(17, 20 * 256);
    sheet.setColumnWidth(18, 20 * 256);
    sheet.setColumnWidth(19, 15 * 256);
    sheet.setColumnWidth(20, 8 * 256);
    sheet.setColumnWidth(21, 25 * 256);
    sheet.setColumnWidth(22, 14 * 256);
    sheet.setColumnWidth(23, 15 * 256);
    sheet.setColumnWidth(24, 15 * 256);
    sheet.setColumnWidth(25, 15 * 256);
    //6. 创建标题行
    HSSFRow r0 = sheet.createRow(0);
    HSSFCell c0 = r0.createCell(0);
    c0.setCellValue("编号");
    c0.setCellStyle(headerStyle);
    HSSFCell c1 = r0.createCell(1);
    c1.setCellStyle(headerStyle);
    c1.setCellValue("姓名");
    HSSFCell c2 = r0.createCell(2);
    c2.setCellStyle(headerStyle);
    c2.setCellValue("工号");
    HSSFCell c3 = r0.createCell(3);
    c3.setCellStyle(headerStyle);
    c3.setCellValue("性别");
    HSSFCell c4 = r0.createCell(4);
    c4.setCellStyle(headerStyle);
    c4.setCellValue("出生日期");
    HSSFCell c5 = r0.createCell(5);
    c5.setCellStyle(headerStyle);
    c5.setCellValue("身份证号码");
    HSSFCell c6 = r0.createCell(6);
    c6.setCellStyle(headerStyle);
    c6.setCellValue("婚姻状况");
    HSSFCell c7 = r0.createCell(7);
    c7.setCellStyle(headerStyle);
    c7.setCellValue("民族");
    HSSFCell c8 = r0.createCell(8);
    c8.setCellStyle(headerStyle);
    c8.setCellValue("籍贯");
    HSSFCell c9 = r0.createCell(9);
    c9.setCellStyle(headerStyle);
    c9.setCellValue("政治面貌");
    HSSFCell c10 = r0.createCell(10);
    c10.setCellStyle(headerStyle);
    c10.setCellValue("电话号码");
    HSSFCell c11 = r0.createCell(11);
    c11.setCellStyle(headerStyle);
    c11.setCellValue("联系地址");
    HSSFCell c12 = r0.createCell(12);
    c12.setCellStyle(headerStyle);
    c12.setCellValue("所属部门");
    HSSFCell c13 = r0.createCell(13);
    c13.setCellStyle(headerStyle);
    c13.setCellValue("职称");
    HSSFCell c14 = r0.createCell(14);
    c14.setCellStyle(headerStyle);
    c14.setCellValue("职位");
    HSSFCell c15 = r0.createCell(15);
    c15.setCellStyle(headerStyle);
    c15.setCellValue("聘用形式");
    HSSFCell c16 = r0.createCell(16);
    c16.setCellStyle(headerStyle);
    c16.setCellValue("最高学历");
    HSSFCell c17 = r0.createCell(17);
    c17.setCellStyle(headerStyle);
    c17.setCellValue("专业");
    HSSFCell c18 = r0.createCell(18);
    c18.setCellStyle(headerStyle);
    c18.setCellValue("毕业院校");
    HSSFCell c19 = r0.createCell(19);
    c19.setCellStyle(headerStyle);
    c19.setCellValue("入职日期");
    HSSFCell c20 = r0.createCell(20);
    c20.setCellStyle(headerStyle);
    c20.setCellValue("在职状态");
    HSSFCell c21 = r0.createCell(21);
    c21.setCellStyle(headerStyle);
    c21.setCellValue("邮箱");
    HSSFCell c22 = r0.createCell(22);
    c22.setCellStyle(headerStyle);
    c22.setCellValue("合同期限(年)");
    HSSFCell c23 = r0.createCell(23);
    c23.setCellStyle(headerStyle);
    c23.setCellValue("合同起始日期");
    HSSFCell c24 = r0.createCell(24);
    c24.setCellStyle(headerStyle);
    c24.setCellValue("合同终止日期");
    HSSFCell c25 = r0.createCell(25);
    c25.setCellStyle(headerStyle);
    c25.setCellValue("转正日期");
    for (int i = 0; i < list.size(); i++) {
      Employee emp = list.get(i);
      HSSFRow row = sheet.createRow(i + 1);
      row.createCell(0).setCellValue(emp.getId());
      row.createCell(1).setCellValue(emp.getName());
      row.createCell(2).setCellValue(emp.getWorkID());
      row.createCell(3).setCellValue(emp.getGender());
      HSSFCell cell4 = row.createCell(4);
      cell4.setCellStyle(dateCellStyle);
      cell4.setCellValue(emp.getBirthday());
      row.createCell(5).setCellValue(emp.getIdCard());
      row.createCell(6).setCellValue(emp.getWedlock());
      row.createCell(7).setCellValue(emp.getNation().getName());
      row.createCell(8).setCellValue(emp.getNativePlace());
      row.createCell(9).setCellValue(emp.getPoliticsstatus().getName());
      row.createCell(10).setCellValue(emp.getPhone());
      row.createCell(11).setCellValue(emp.getAddress());
      row.createCell(12).setCellValue(emp.getDepartment().getName());
      row.createCell(13).setCellValue(emp.getJobLevel().getName());
      row.createCell(14).setCellValue(emp.getPosition().getName());
      row.createCell(15).setCellValue(emp.getEndContract());
      row.createCell(16).setCellValue(emp.getTiptopDegree());
      row.createCell(17).setCellValue(emp.getSpecialty());
      row.createCell(18).setCellValue(emp.getSchool());
      HSSFCell cell19 = row.createCell(19);
      cell19.setCellStyle(dateCellStyle);
      cell19.setCellValue(emp.getBirthday());
      row.createCell(20).setCellValue(emp.getWorkState());
      row.createCell(21).setCellValue(emp.getEmail());
      row.createCell(22).setCellValue(emp.getContractTerm());
      HSSFCell cell23 = row.createCell(23);
      cell23.setCellStyle(dateCellStyle);
      cell23.setCellValue(emp.getBeginContract());
      HSSFCell cell24 = row.createCell(24);
      cell24.setCellStyle(dateCellStyle);
      cell24.setCellValue(emp.getEndContract());
      HSSFCell cell25 = row.createCell(25);
      cell25.setCellStyle(dateCellStyle);
      cell25.setCellValue(emp.getConversionTime());
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    HttpHeaders headers = new HttpHeaders();
    try {
      headers.setContentDispositionFormData("attachment",
                                            new String("员工表.xls".getBytes(
                                                StandardCharsets.UTF_8),
                                                       StandardCharsets.ISO_8859_1));
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      workbook.write(baos);
      workbook.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>(baos.toByteArray(), headers,
                                HttpStatus.CREATED);
  }


  /**
   * 部门工资表集合转换成Excel
   *
   * @param list
   * @return
   */
  public static ResponseEntity<byte[]> depSalary2Excel(List<Employee> list) {
    //因为是同部门的信息，所以部门信息是相同的
    String departName = "";
    if (!list.isEmpty()) {
      departName = list.get(0).getDepartment().getName();
    }
    //1. 创建一个 Excel 文档
    HSSFWorkbook workbook = new HSSFWorkbook();
    //2. 创建文档摘要
    workbook.createInformationProperties();
    //3. 获取并配置文档信息
    DocumentSummaryInformation docInfo = workbook
        .getDocumentSummaryInformation();
    //文档类别
    docInfo.setCategory(departName + "部门工资表");
    //文档管理员
    docInfo.setManager("admin");
    //设置公司信息
    docInfo.setCompany("Company");
    //4. 获取文档摘要信息
    SummaryInformation summInfo = workbook.getSummaryInformation();
    //文档标题
    summInfo.setTitle(departName + "部门工资表");
    //文档作者
    summInfo.setAuthor("admin");
    // 文档备注
    summInfo.setComments("本文档由POI组装");
    //5. 创建样式
    //创建标题行的样式
    HSSFCellStyle headerStyle = workbook.createCellStyle();
    headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
    headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    HSSFCellStyle dateCellStyle = workbook.createCellStyle();
    dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
    HSSFSheet sheet = workbook.createSheet(departName + "部门工资表");
    //设置列的宽度
    sheet.setColumnWidth(0, 15 * 256);
    sheet.setColumnWidth(1, 12 * 256);
    sheet.setColumnWidth(2, 10 * 256);
    sheet.setColumnWidth(3, 10 * 256);
    sheet.setColumnWidth(4, 15 * 256);
    sheet.setColumnWidth(5, 12 * 256);
    sheet.setColumnWidth(6, 20 * 256);
    sheet.setColumnWidth(7, 10 * 256);
    sheet.setColumnWidth(8, 10 * 256);
    sheet.setColumnWidth(9, 16 * 256);
    sheet.setColumnWidth(10, 12 * 256);
    sheet.setColumnWidth(11, 15 * 256);
    sheet.setColumnWidth(12, 20 * 256);
    sheet.setColumnWidth(13, 16 * 256);
    sheet.setColumnWidth(14, 16 * 256);
    //6. 创建标题行
    HSSFRow r0 = sheet.createRow(0);
    HSSFCell c0 = r0.createCell(0);
    c0.setCellValue("员工姓名");
    c0.setCellStyle(headerStyle);
    HSSFCell c1 = r0.createCell(1);
    c1.setCellStyle(headerStyle);
    c1.setCellValue("基本工资");
    HSSFCell c2 = r0.createCell(2);
    c2.setCellStyle(headerStyle);
    c2.setCellValue("部门奖金");
    HSSFCell c3 = r0.createCell(3);
    c3.setCellStyle(headerStyle);
    c3.setCellValue("个人奖金");
    HSSFCell c4 = r0.createCell(4);
    c4.setCellStyle(headerStyle);
    c4.setCellValue("午餐补助");
    HSSFCell c5 = r0.createCell(5);
    c5.setCellStyle(headerStyle);
    c5.setCellValue("交通补助");
    HSSFCell c6 = r0.createCell(6);
    c6.setCellStyle(headerStyle);
    c6.setCellValue("养老金基数");
    HSSFCell c7 = r0.createCell(7);
    c7.setCellStyle(headerStyle);
    c7.setCellValue("养老金比率%");
    HSSFCell c8 = r0.createCell(8);
    c8.setCellStyle(headerStyle);
    c8.setCellValue("医疗保险基数");
    HSSFCell c9 = r0.createCell(9);
    c9.setCellStyle(headerStyle);
    c9.setCellValue("养老保险比率%");
    HSSFCell c10 = r0.createCell(10);
    c10.setCellStyle(headerStyle);
    c10.setCellValue("公积金基数");
    HSSFCell c11 = r0.createCell(11);
    c11.setCellStyle(headerStyle);
    c11.setCellValue("公积金比率%");
    HSSFCell c12 = r0.createCell(12);
    c12.setCellStyle(headerStyle);
    c12.setCellValue("应发工资(未算入奖金)");
    HSSFCell c13 = r0.createCell(13);
    c13.setCellStyle(headerStyle);
    c13.setCellValue("应发工资(算入奖金)");
    for (int i = 0; i < list.size(); i++) {
      Employee emp = list.get(i);
      HSSFRow row = sheet.createRow(i + 1);
      row.createCell(0).setCellValue(emp.getName());
      row.createCell(1).setCellValue(emp.getSalary().getBasicSalary());
      row.createCell(2).setCellValue(emp.getSalary().getBonus());
      row.createCell(3).setCellValue(null == emp.getAdjustSalary() ? 0
                                         : emp.getAdjustSalary().getAmount());
      row.createCell(4).setCellValue(emp.getSalary().getLunchSalary());
      row.createCell(5).setCellValue(emp.getSalary().getTrafficSalary());
      row.createCell(6).setCellValue(emp.getSalary().getPensionBase());
      row.createCell(7).setCellValue(emp.getSalary().getPensionPer());
      row.createCell(8).setCellValue(emp.getSalary().getMedicalBase());
      row.createCell(9).setCellValue(emp.getSalary().getMedicalPer());
      row.createCell(10)
          .setCellValue(emp.getSalary().getAccumulationFundBase());
      row.createCell(11).setCellValue(emp.getSalary().getAccumulationFundPer());
      row.createCell(12).setCellValue(emp.getSalary().getAllSalary());
      row.createCell(13).setCellValue(emp.getSalaryWithBonus());
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    HttpHeaders headers = new HttpHeaders();
    try {
      headers.setContentDispositionFormData("attachment",
                                            new String(
                                                (departName + "部门工资表.xls")
                                                    .getBytes(
                                                        StandardCharsets.UTF_8),
                                                StandardCharsets.ISO_8859_1));
      headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
      workbook.write(baos);
      workbook.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new ResponseEntity<>(baos.toByteArray(), headers,
                                HttpStatus.CREATED);
  }
}
