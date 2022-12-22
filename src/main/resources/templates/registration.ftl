<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h3>${message!" " }</h3>
    <@l.login "/registration", "Регистрация">
    </@l.login>
</@c.page>