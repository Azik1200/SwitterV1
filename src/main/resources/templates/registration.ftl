<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h3>${message?if_exists}</h3>
    <@l.login "/registration", "Регистрация">
    </@l.login>
</@c.page>