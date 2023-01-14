
<div class="card-columns">
    <#list messages as message>
        <div class="card my-3">
            <#if message.filename??>
                <img src="/images/${message.filename}" class="card-img-top">
            </#if>
            <div class="m-2">
                <span>${message.text}</span>
                <i>${message.tag}</i>
            </div>
            <div class="card-footer text-muted">
                ${message.authorName}
            </div>
        </div>
    <#else>
        <h4 class="mt-3">Сообщений нет!</h4>
    </#list>
</div>