package com.example.demo.rest.req;

import javax.validation.constraints.*;

public class DemoValidationReq {
    @Min(value = 1, message = "Id只能大于等于1，小于等于10")
    @Max(value = 10, message = "Id只能大于等于1，小于等于10")
    private Integer length;
    @Size(min = 2, max = 4, message = "姓名长度必须在{min}和{max}之间")
    private String size;
    @NotNull(message = "不能为空!")
    @NotBlank(message = "不能为空!")
    private String nullAndEmpty;

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getNullAndEmpty() {
        return nullAndEmpty;
    }

    public void setNullAndEmpty(String nullAndEmpty) {
        this.nullAndEmpty = nullAndEmpty;
    }
}
