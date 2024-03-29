<#import "parts/common.ftl" as c>

<@c.page>
    <h4>Cписок пользователей</h4>
    <table>
        <thead>
        <tr>
            <th>Имя</th>
            <th>Роль</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
            <tr>
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td><a href="/user/${user.id}">Редактировать</a></td>
            </tr>
        </#list>
        </tbody>
    </table>
</@c.page>