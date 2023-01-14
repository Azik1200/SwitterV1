<#include "security.ftl">
<#import "login.ftl" as l>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">Switter</a>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="/">Домой</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/main">Сообщения</a>
            </li>
            <#if known>
            <#if isAdmin>
                <li class="nav-item">
                    <a class="nav-link" href="/user">Список пользователей</a>
                </li>
            </#if>
            <#if user??>
                <li class="nav-item">
                    <a class="nav-link" href="/user-messages/${currentUserId}">Мои Сообщения</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/user/profile">Профиль</a>
                </li>
            </#if>
        </ul>

        <div class="navbar-text mr-3">${name}</div>
        <@l.logout />
        <#else>
            <div class="navbar-text mr-3">Гость</div>
        </#if>
    </div>
</nav>