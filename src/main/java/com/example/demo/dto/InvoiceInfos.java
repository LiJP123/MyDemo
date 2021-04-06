package com.example.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
@ToString(callSuper = true)
@XmlAccessorType(XmlAccessType.FIELD)
// XML文件中的根标识
@XmlRootElement(name = "invoiceInfos")
// 控制JAXB 绑定类中属性和字段的排序
@XmlType(propOrder = {
        "invoiceInfo"
})
public class InvoiceInfos {
    private List<InvoiceInfo> invoiceInfo;
}
