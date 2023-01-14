<#include "security.ftl">

<div class="card-columns">
    <#list messages as message>
        <div class="card my-3">
            <#if message.filename??>
                <img src="/images/${message.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <br />
                <i>#${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                <a href="/user-messages/${message.author.id}"> ${message.authorName} </a>
                <#if message.author.id == currentUserId || isAdmin>
                <a href="/user-messages/${message.author.id}?message=${message.id}" class="btn btn-primary">Изменить</a>
                </#if>
            </div>
        </div>
    <#else>
        <h4 class="mt-3">Сообщений нет!</h4>
    </#list>
</div>