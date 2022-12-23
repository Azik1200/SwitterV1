<#import "parts/common.ftl" as c>

<@c.page>
    <h4>Редактор пользователя</h4>

    <form action="/user" method="post">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label>
                    <input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?("checked", "")}>
                    ${role}
                </label>
            </div>
        </#list>
        <input type="hidden" name="userID" value="${user.id}">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <button type="submit">Сохранить</button>
    </form>
</@c.page>