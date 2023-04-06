package com.chailong.controller;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.chailong.pojo.Salary;
import com.chailong.pojo.StaffInformation;
import com.chailong.pojo.attendence;
import com.chailong.service.AttendanceService;
import com.chailong.service.SalaryService;
import com.chailong.service.StaffService;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentController {
    @Reference
    private StaffService staffService;
    @Reference
    private AttendanceService attendanceService;
    @Reference
    private SalaryService salaryService;
    @RequestMapping("/export_staffinfo_Excel")
    @ResponseBody
    public String exportstaffExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询数据列表
        List<StaffInformation> list = staffService.selectALlstaff();
        if (list != null && list.size() >= 0) {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFCellStyle setBorder = wb.createCellStyle();
            setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            HSSFFont font = wb.createFont();
            font.setFontName("黑体");
            font.setFontHeightInPoints((short) 22);// 设置字体大小
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder.setFont(font);
            HSSFCellStyle setBorder1 = wb.createCellStyle();
            HSSFFont font1 = wb.createFont();
            setBorder1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder1.setWrapText(true);// 设置自动换行
            font1.setFontHeightInPoints((short) 10);
            font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder1.setFont(font1);
            setBorder1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFFont font2 = wb.createFont();
            font2.setFontHeightInPoints((short) 10);
            HSSFCellStyle setBorder2 = wb.createCellStyle();
            setBorder2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder2.setWrapText(true);// 设置自动换行
            setBorder2.setFont(font2);
            setBorder2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFSheet sheet = wb.createSheet("xxx记录");
            // 设置列宽
            sheet.setColumnWidth(0, 5*256);//5*256 		序号
            sheet.setColumnWidth(1, 23*256);//23*256 	姓名
            sheet.setColumnWidth(2, 13*256);//13*256	手机号
            // 创建单元格
            HSSFRow row = sheet.createRow(0);
            HSSFCell c0 = row.createCell(0);
            c0.setCellValue(new HSSFRichTextString("工号"));
            c0.setCellStyle(setBorder1);
            HSSFCell c1 = row.createCell(1);
            c1.setCellValue(new HSSFRichTextString("姓名"));
            c1.setCellStyle(setBorder1);
            HSSFCell c2 = row.createCell(2);
            c2.setCellValue(new HSSFRichTextString("年龄"));
            c2.setCellStyle(setBorder1);
            HSSFCell c3 = row.createCell(3);
            c3.setCellValue(new HSSFRichTextString("性别"));
            c3.setCellStyle(setBorder1);
            HSSFCell c4 = row.createCell(4);
            c4.setCellValue(new HSSFRichTextString("学历"));
            c4.setCellStyle(setBorder1);
            HSSFCell c5 = row.createCell(5);
            c5.setCellValue(new HSSFRichTextString("职位"));
            c5.setCellStyle(setBorder1);
            HSSFCell c6 = row.createCell(6);
            c6.setCellValue(new HSSFRichTextString("身份证"));
            c6.setCellStyle(setBorder1);
            HSSFCell c7 = row.createCell(7);
            c7.setCellValue(new HSSFRichTextString("地址"));
            c7.setCellStyle(setBorder1);
            HSSFCell c8 = row.createCell(8);
            c8.setCellValue(new HSSFRichTextString("联系电话"));
            c8.setCellStyle(setBorder1);
            int count = 1;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                HSSFRow r = sheet.createRow((i + 1));
                HSSFCell[] headerCell12 = new HSSFCell[9];
                headerCell12[0] = r.createCell(0);
                headerCell12[0].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getStaffId())));
                headerCell12[0].setCellStyle(setBorder2);
                headerCell12[1] = r.createCell(1);
                headerCell12[1].setCellValue(new HSSFRichTextString(list.get(i).getStaffname()));
                headerCell12[1].setCellStyle(setBorder2);
                headerCell12[2] = r.createCell(2);
                headerCell12[2].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getStaffage())));
                headerCell12[2].setCellStyle(setBorder2);
                headerCell12[3] = r.createCell(3);
                headerCell12[3].setCellValue(new HSSFRichTextString(list.get(i).getStaffsex()));
                headerCell12[3].setCellStyle(setBorder2);
                headerCell12[4] = r.createCell(4);
                headerCell12[4].setCellValue(new HSSFRichTextString(list.get(i).getEducationBackground()));
                headerCell12[4].setCellStyle(setBorder2);
                headerCell12[5] = r.createCell(5);
                headerCell12[5].setCellValue(new HSSFRichTextString(list.get(i).getDuty()));
                headerCell12[5].setCellStyle(setBorder2);
                headerCell12[6] = r.createCell(6);
                headerCell12[6].setCellValue(new HSSFRichTextString(list.get(i).getIdcard()));
                headerCell12[6].setCellStyle(setBorder2);
                headerCell12[7] = r.createCell(7);
                headerCell12[7].setCellValue(new HSSFRichTextString(list.get(i).getAddress()));
                headerCell12[7].setCellStyle(setBorder2);
                headerCell12[8] = r.createCell(8);
                headerCell12[8].setCellValue(new HSSFRichTextString(list.get(i).getPhonenumber()));
                headerCell12[8].setCellStyle(setBorder2);
            }
            //反馈给前台状态
            response.getWriter().append("ok");
            //XSSFWorkbook对象保持到session里，供下载使用
            request.getSession().setAttribute("XSSFWorkbook",wb);
        }
        return null;
    }

    @RequestMapping("/export_attinfo_Excel")
    @ResponseBody
    public String exportattExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询数据列表
        List<attendence> list=attendanceService.attendence();
        if (list != null && list.size() >= 0) {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFCellStyle setBorder = wb.createCellStyle();
            setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            HSSFFont font = wb.createFont();
            font.setFontName("黑体");
            font.setFontHeightInPoints((short) 22);// 设置字体大小
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder.setFont(font);
            HSSFCellStyle setBorder1 = wb.createCellStyle();
            HSSFFont font1 = wb.createFont();
            setBorder1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder1.setWrapText(true);// 设置自动换行
            font1.setFontHeightInPoints((short) 10);
            font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder1.setFont(font1);
            setBorder1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFFont font2 = wb.createFont();
            font2.setFontHeightInPoints((short) 10);
            HSSFCellStyle setBorder2 = wb.createCellStyle();
            setBorder2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder2.setWrapText(true);// 设置自动换行
            setBorder2.setFont(font2);
            setBorder2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFSheet sheet = wb.createSheet("xxx记录");
            // 设置列宽
            sheet.setColumnWidth(0, 5*256);//5*256 		序号
            sheet.setColumnWidth(1, 23*256);//23*256 	姓名
            sheet.setColumnWidth(2, 13*256);//13*256	手机号
            // 创建单元格
            HSSFRow row = sheet.createRow(0);
            HSSFCell c0 = row.createCell(0);
            c0.setCellValue(new HSSFRichTextString("考勤ID"));
            c0.setCellStyle(setBorder1);
            HSSFCell c1 = row.createCell(1);
            c1.setCellValue(new HSSFRichTextString("考勤类型"));
            c1.setCellStyle(setBorder1);
            HSSFCell c2 = row.createCell(2);
            c2.setCellValue(new HSSFRichTextString("时间"));
            c2.setCellStyle(setBorder1);
            HSSFCell c3 = row.createCell(3);
            c3.setCellValue(new HSSFRichTextString("员工ID"));
            c3.setCellStyle(setBorder1);
            HSSFCell c4 = row.createCell(4);
            c4.setCellValue(new HSSFRichTextString("员工姓名"));
            c4.setCellStyle(setBorder1);
            int count = 1;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                HSSFRow r = sheet.createRow((i + 1));
                HSSFCell[] headerCell12 = new HSSFCell[9];
                headerCell12[0] = r.createCell(0);
                headerCell12[0].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getAttendanceId())));
                headerCell12[0].setCellStyle(setBorder2);
                headerCell12[1] = r.createCell(1);
                headerCell12[1].setCellValue(new HSSFRichTextString(list.get(i).getAttendancetype()));
                headerCell12[1].setCellStyle(setBorder2);
                headerCell12[2] = r.createCell(2);
                headerCell12[2].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getAttendancetime())));
                headerCell12[2].setCellStyle(setBorder2);
                headerCell12[3] = r.createCell(3);
                headerCell12[3].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getStaffInformation().getStaffId())));
                headerCell12[3].setCellStyle(setBorder2);
                headerCell12[4] = r.createCell(4);
                headerCell12[4].setCellValue(new HSSFRichTextString(list.get(i).getStaffInformation().getStaffname()));
                headerCell12[4].setCellStyle(setBorder2);
            }
            //反馈给前台状态
            response.getWriter().append("ok");
            //XSSFWorkbook对象保持到session里，供下载使用
            request.getSession().setAttribute("XSSFWorkbook",wb);
        }
        return null;
    }
    @RequestMapping("/export_salaryinfo_Excel")
    @ResponseBody
    public String exportsalaryExcel(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //查询数据列表
        List<Salary> list=salaryService.getallsalaryinfo();
        System.out.println(list);
        if (list != null && list.size() >= 0) {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFCellStyle setBorder = wb.createCellStyle();
            setBorder.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            HSSFFont font = wb.createFont();
            font.setFontName("黑体");
            font.setFontHeightInPoints((short) 22);// 设置字体大小
            font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder.setFont(font);
            HSSFCellStyle setBorder1 = wb.createCellStyle();
            HSSFFont font1 = wb.createFont();
            setBorder1.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder1.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder1.setWrapText(true);// 设置自动换行
            font1.setFontHeightInPoints((short) 10);
            font1.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);// 粗体显示
            setBorder1.setFont(font1);
            setBorder1.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder1.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFFont font2 = wb.createFont();
            font2.setFontHeightInPoints((short) 10);
            HSSFCellStyle setBorder2 = wb.createCellStyle();
            setBorder2.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 居中
            setBorder2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
            setBorder2.setWrapText(true);// 设置自动换行
            setBorder2.setFont(font2);
            setBorder2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderTop(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderRight(HSSFCellStyle.BORDER_THIN);
            setBorder2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            HSSFSheet sheet = wb.createSheet("xxx记录");
            // 设置列宽
            sheet.setColumnWidth(0, 5*256);//5*256 		序号
            sheet.setColumnWidth(1, 23*256);//23*256 	姓名
            sheet.setColumnWidth(2, 13*256);//13*256	手机号
            // 创建单元格
            HSSFRow row = sheet.createRow(0);
            HSSFCell c0 = row.createCell(0);
            c0.setCellValue(new HSSFRichTextString("工资编号"));
            c0.setCellStyle(setBorder1);
            HSSFCell c1 = row.createCell(1);
            c1.setCellValue(new HSSFRichTextString("员工ID"));
            c1.setCellStyle(setBorder1);
            HSSFCell c2 = row.createCell(2);
            c2.setCellValue(new HSSFRichTextString("员工姓名"));
            c2.setCellStyle(setBorder1);
            HSSFCell c3 = row.createCell(3);
            c3.setCellValue(new HSSFRichTextString("工资总额"));
            c3.setCellStyle(setBorder1);
            HSSFCell c4 = row.createCell(4);
            c4.setCellValue(new HSSFRichTextString("年份"));
            c4.setCellStyle(setBorder1);
            HSSFCell c5 = row.createCell(5);
            c5.setCellValue(new HSSFRichTextString("月份"));
            c5.setCellStyle(setBorder1);
            HSSFCell c6 = row.createCell(6);
            c6.setCellValue(new HSSFRichTextString("状态"));
            c6.setCellStyle(setBorder1);
            int count = 1;
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                HSSFRow r = sheet.createRow((i + 1));
                HSSFCell[] headerCell12 = new HSSFCell[7];
                headerCell12[0] = r.createCell(0);
                headerCell12[0].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getSalaryId())));
                headerCell12[0].setCellStyle(setBorder2);
                headerCell12[1] = r.createCell(1);
                headerCell12[1].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getStaffInformation().getStaffId())));
                headerCell12[1].setCellStyle(setBorder2);
                headerCell12[2] = r.createCell(2);
                headerCell12[2].setCellValue(new HSSFRichTextString(list.get(i).getStaffInformation().getStaffname()));
                headerCell12[2].setCellStyle(setBorder2);
                headerCell12[3] = r.createCell(3);
                headerCell12[3].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getSalarynum())));
                headerCell12[3].setCellStyle(setBorder2);
                headerCell12[4] = r.createCell(4);
                headerCell12[4].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getSalaryyear())));
                headerCell12[4].setCellStyle(setBorder2);
                headerCell12[5] = r.createCell(5);
                headerCell12[5].setCellValue(new HSSFRichTextString(String.valueOf(list.get(i).getSalarymouth())));
                headerCell12[5].setCellStyle(setBorder2);
                headerCell12[6] = r.createCell(6);
                headerCell12[6].setCellValue(new HSSFRichTextString(list.get(i).getSalarystatue()));
                headerCell12[6].setCellStyle(setBorder2);
            }
            //反馈给前台状态
            response.getWriter().append("ok");
            //XSSFWorkbook对象保持到session里，供下载使用
            request.getSession().setAttribute("XSSFWorkbook",wb);
        }
        return null;
    }

    @RequestMapping("downloadExcel_d")
    public void download_staff_Excel_d(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "员工信息报表.xlsx";
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));//设置文件头编码格式
            response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头
            HSSFWorkbook wb = (HSSFWorkbook) request.getSession().getAttribute("XSSFWorkbook");
            request.getSession().removeAttribute("XSSFWorkbook");
            wb.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("downloadExcel_f")
    public void download_att_Excel_d(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "考勤信息报表.xlsx";
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));//设置文件头编码格式
            response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头
            HSSFWorkbook wb = (HSSFWorkbook) request.getSession().getAttribute("XSSFWorkbook");
            request.getSession().removeAttribute("XSSFWorkbook");
            wb.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("downloadExcel_g")
    public void download_salary_Excel_d(HttpServletRequest request, HttpServletResponse response) {
        try {
            String fileName = "工资信息报表.xlsx";
            response.setHeader("Content-disposition", "attachment;filename="
                    + new String(fileName.getBytes("utf-8"), "ISO8859-1"));//设置文件头编码格式
            response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");//设置类型
            response.setHeader("Cache-Control", "no-cache");//设置头
            response.setDateHeader("Expires", 0);//设置日期头
            HSSFWorkbook wb = (HSSFWorkbook) request.getSession().getAttribute("XSSFWorkbook");
            request.getSession().removeAttribute("XSSFWorkbook");
            wb.write(response.getOutputStream());
            response.getOutputStream().flush();
            response.getOutputStream().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
