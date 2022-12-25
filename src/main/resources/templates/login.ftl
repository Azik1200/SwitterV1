<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h3 class="mb-4">${message?if_exists}</h3>
    <@l.login "/login", false>
    </@l.login>
    <br>
</@c.page>