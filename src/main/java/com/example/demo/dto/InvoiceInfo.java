package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "invoiceInfos")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "invCode",
        "invNo",
        "invDate",
        "totalAmount",
        "totalTax",
        "pdfContent"
})
public class InvoiceInfo {
    /**
     *	发票代码
     */
    private String invCode;
    /**
     *	发票号码
     */
    private String invNo;
    /**
     *	开票时间
     */
    private String invDate;
    /**
     *	合计金额
     */
    private String totalAmount;
    /**
     *	合计税额
     */
    private String totalTax;
    /**
     *	pdf文件
     */
    private String pdfContent;
}
