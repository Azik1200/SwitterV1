<#macro login path, name>
    <h4>${name}</h4>
    <form action="${path}" method="post">
        <div><label> Имя пользователя : <input type="text" name="username"/> </label></div>
        <div><label> Пароль : <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <br>
        <div><input type="submit" value="${name}"/></div>
    </form>
    <br>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Выйти"/>
    </form>
</#macro>