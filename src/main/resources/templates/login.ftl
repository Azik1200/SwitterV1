<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
<@l.login "/login", "Войти">
</@l.login>
<br>
<a href="/registration">Регистрация</a>
</@c.page>