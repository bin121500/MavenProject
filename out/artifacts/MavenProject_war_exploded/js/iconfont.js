var path;
var userAccount;
var doctorAccount;
var fieldId;
$(function () {
    path = $("#path").val();
    userAccount = $("#userAccount").val();

    $(".mytd").on('click', function () {
        // console.log(this.bgColor)
        for (var i = 0; i < $(".mytd").length; i++) {
            if ($(".mytd")[i].bgColor == '#31ff3b') {
                $(".mytd")[i].bgColor = '#FFFFFF'
                // console.log($(".mytd")[i])
            }
        }
        if (this.bgColor != '#ff3131' && fieldId != undefined && doctorAccount != undefined&&this.bgColor != '#a9a9a9') {
            this.bgColor = '#31ff3b'
        }
    })

    var now = new Date();
    var day = ("" + now.getDate()).slice(-2);
    var month = ("" + (now.getMonth() + 1)).slice(-2);
    var today = now.getFullYear() + "-" + (month) + "-" + (day);
    $("#sysdata").val(today)

    //我的预约鼠标悬停事件
    $('#myyuyue').mouseover(function () {
        console.log(this.innerHTML = '&#xe621;我的预约!')
    }).mouseout(function () {
        console.log(this.innerHTML = '&#xe621;我的预约')
    })
})

function field_select_change(s) {
    fieldId = s;
    // console.log(s)
    if (fieldId !== 'default') {
        $.ajax({
            url: path + "/UserServlet?methodName=findDoctorByFieldId&fieldId=" + s,
            method: "get",
            dataType: "text",
            beforeSend: function () {
            },
            success: function (response) {
                var splitText = response.split('&');
                if (splitText[0] == 'succeed') {
                    // console.log(splitText[1])
                    var arraydata = eval(splitText[1]);
                    // console.log(arraydata.length)
                    $("#doctor_select").empty()//移除所有子标签
                    $("#doctor_select").append("<option  value='default' >--选择心理医生--</option>")
                    for (var i = 0; i < arraydata.length; i++) {
                        $("#doctor_select").append("<option  value='" + arraydata[i].adminAccount + "' >" + arraydata[i].adminName + "</option>")
                    }
                    // console.log($("#doctor_select").appendChild("<option  value='选择心理医生' >--选择心理医生--</option>"));
                }
            },
            error: function () {

            },
            complete: function () {
            }
        })
    }
}

function doctor_select_change(s) {
    var sysdata = $("#sysdata").val();
    doctorAccount = s;
    if (doctorAccount !== 'default') {
        $.ajax({
            url: path + "/UserServlet?methodName=getDoctorInfByAccount&account=" + s + "&sysdata=" + sysdata,//查找医生信息并且返回该医生被预约的时间段
            method: "get",
            dataType: "text",
            beforeSend: function () {
            },
            success: function (response) {
                var splitText = response.split('&');
                if (splitText[0] == 'succeed') {
                    var parse = JSON.parse(splitText[1]);
                    $("#adminName").text('' + parse.adminName)
                    $("#adminSchool").text('' + parse.adminSchool)
                    $("#adminMajor").text('' + parse.adminMajor)
                    $("#adminPrice").text('服务价格:' + parse.adminPrice + '元/次')
                    $("#adminMasc").text('专业背景:' + parse.adminMasc)
                    var timearr = JSON.parse(splitText[2]);
                    clearRed();
                    // console.log(timearr)
                    for (var i = 0; i < timearr.length; i++) {
                        var test = "[name='" + timearr[i] + "']"
                        $(test)[0].bgColor = '#ff3131'
                        // $(test).css('background-color', '#ff3131')
                    }
                    var doctorArrange = splitText[3];
                    setDoctorArrangeColor(doctorArrange)
                }
            },
        })
    }
}

function nextDay(node) {
    var now = $("#sysdata").val();
    var d = new Date(now);
    d.setDate(d.getDate() + 1);
    var m = d.getMonth() + 1;
    $("#sysdata").val(d.getFullYear() + '-' + m + '-' + d.getDate());

    if (fieldId != undefined && doctorAccount != undefined) {
        $.ajax({
            url: path + "/UserServlet?methodName=getDoctorInfByAccount&account=" + doctorAccount + "&sysdata=" + $("#sysdata").val(),//查找医生信息并且返回该医生被预约的时间段
            method: "get",
            dataType: "text",
            beforeSend: function () {
            },
            success: function (response) {
                var splitText = response.split('&');
                if (splitText[0] == 'succeed') {
                    var parse = JSON.parse(splitText[1]);
                    $("#adminName").text('' + parse.adminName)
                    $("#adminSchool").text('' + parse.adminSchool)
                    $("#adminMajor").text('' + parse.adminMajor)
                    $("#adminPrice").text('服务价格:' + parse.adminPrice + '元/次')
                    $("#adminMasc").text('专业背景:' + parse.adminMasc)
                    var timearr = JSON.parse(splitText[2]);
                    clearRed();
                    for (var i = 0; i < timearr.length; i++) {
                        var test = "[name='" + timearr[i] + "']"
                        $(test)[0].bgColor = '#ff3131'
                    }
                    var doctorArrange = splitText[3];
                    setDoctorArrangeColor(doctorArrange)
                }
            },
            error: function () {
            },
            complete: function () {
            }
        })
    }

}

function lastDay(node) {
    var d = new Date();
    var time = d.getFullYear() + "-" + 0 + (d.getMonth() + 1) + "-" + d.getDate();
    var times = time.split("-");
    var num = 0;
    var eDate = document.getElementById("sysdata").value.split("-");
    if (Number(eDate[0]) <= Number(times[0])) {
        if (Number(eDate[1]) <= Number(times[1])) {
            if (Number(eDate[2]) <= Number(times[2])) {
                num = 1;
            }
        }
    }
    if (num == 1) {
        alert("结束日期不能小于开始日期");
    } else {
        var str = document.getElementById("sysdata").value;
        var d = new Date(str);
        d.setDate(d.getDate() - 1);
        var m = d.getMonth() + 1;
        document.getElementById("sysdata").value = d.getFullYear() + '-' + m + '-' + d.getDate();

        //日期切换查询医生排班
        if (fieldId != undefined && doctorAccount != undefined) {
            $.ajax({
                url: path + "/UserServlet?methodName=getDoctorInfByAccount&account=" + doctorAccount + "&sysdata=" + $("#sysdata").val(),//查找医生信息并且返回该医生被预约的时间段
                method: "get",
                dataType: "text",
                beforeSend: function () {
                },
                success: function (response) {
                    var splitText = response.split('&');
                    if (splitText[0] == 'succeed') {
                        var parse = JSON.parse(splitText[1]);
                        $("#adminName").text('' + parse.adminName)
                        $("#adminSchool").text('' + parse.adminSchool)
                        $("#adminMajor").text('' + parse.adminMajor)
                        $("#adminPrice").text('服务价格:' + parse.adminPrice + '元/次')
                        $("#adminMasc").text('专业背景:' + parse.adminMasc)
                        var timearr = JSON.parse(splitText[2]);
                        clearRed();
                        for (var i = 0; i < timearr.length; i++) {
                            var test = "[name='" + timearr[i] + "']"
                            $(test)[0].bgColor = '#ff3131'
                        }
                        var doctorArrange = splitText[3];
                        setDoctorArrangeColor(doctorArrange)
                    }
                },
                error: function () {
                },
                complete: function () {
                }
            })
        }
    }
}

function post_yuyue(node) {
    var timeselect;//当前选中的时间段
    var selectnode;
    for (var i = 0; i < $(".mytd").length; i++) {
        if ($(".mytd")[i].bgColor == '#31ff3b') {
            timeselect = $(".mytd")[i].innerHTML;
            selectnode = $(".mytd")[i];
            break;
        } else {
            timeselect = 'noselecttime'
        }
    }
    var time = $("#sysdata").val() + ' ' + timeselect + ':00';//当前选中的日期
    // console.log(time)
    // console.log(doctorAccount)//预约的咨询师的账号
    // console.log(userAccount)//用户账号
    // console.log(fieldId)//领域id
    if (timeselect == 'noselecttime') {
        alert('请选择预约的时间')
        // console.log($("#diseaseDesc").val())
    } else {
        if ($("#diseaseDesc").val() == '') {
            alert('请添加问题描以方便咨询师诊断')
        } else {
            $.ajax({
                url: path + "/UserServlet?methodName=postRecord",
                method: "post",
                data: {
                    userAccount: userAccount,
                    adminAccount: doctorAccount,
                    fieldId: fieldId,
                    recordTime: time,
                    diseaseDesc: $("#diseaseDesc").val()
                },
                dataType: "text",
                beforeSend: function () {
                },
                success: function (response) {
                    if (response == '预约成功') {
                        alert('预约成功')
                        //预约成功，设置该时间点为红色的不可预约的状态
                        if (selectnode != undefined) {
                            selectnode.bgColor = 'ff3131'
                        }
                    } else if (response == '预约失败') {
                        alert('预约失败')
                    }
                },
                error: function () {
                },
                complete: function () {
                }
            })
        }
    }
}

function clearRed() {
    for (var i = 0; i < $(".mytd").length; i++) {
        if ($(".mytd")[i].bgColor = '#ff3131') {
            $(".mytd")[i].bgColor = '#FFFFFF'
        }
    }
}

function clickmyyuyue(node) {
    $("#iframe").attr('src', 'UserServlet?methodName=getUserRecord&userAccount=' + userAccount);
}

function toUserCenter(node) {
    // location='UserServlet?methodName=getUserInf&userAccount='+userAccount;
    $("#iframe").attr('src', 'UserServlet?methodName=getUserInf&userAccount=' + userAccount);
}

function setDoctorArrangeColor(doctorArrange) {
    var split = doctorArrange.split('-');
    for (var i = 0; i < split.length; i++) {
        var test = "[name='" + split[i] + "']"
        $(test)[0].bgColor = '#a9a9a9'
    }
}
function toTest(s) {
    $("#iframe").attr('src', 'UserServlet?methodName=toOnlineTest');
    // location=path+"/UserServlet?methodName=toOnlineTest"
}