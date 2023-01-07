<#macro login path, isRegisterForm>
    <#if !isRegisterForm>
        <h4>Войти</h4>
    <#else >
        <h4>Регистрация</h4>
    </#if>
    <form action="${path}" method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Имя пользователя :</label>
            <div class="col-sm-6">
                <input type="text" name="username" class="form-control" placeholder="Имя пользователя"/>
            </div>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль :</label>
            <div class="col-sm-6">
                <input type="password" name="password" class="form-control" placeholder="Пароль"/>
            </div>
        </div>
        <#if isRegisterForm>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Повторить пароль :</label>
                <div class="col-sm-6">
                    <input type="password2" name="password2" class="form-control" placeholder="Повторите Пароль"/>
                </div>
            </div>
            <div class="form-group row">
                <label class="col-sm-2 col-form-label">Эл. почта :</label>
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="Эл.почта"/>
                </div>
            </div>
        </#if>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit"><#if isRegisterForm>Регистрация<#else>Войти</#if></button>
        <br>
        <br>
        <br>
        <#if !isRegisterForm><a href="/registration">Добавить пользователя</a></#if>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Выйти</button>
    </form>
</#macro>