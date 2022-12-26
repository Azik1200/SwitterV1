<#import "parts/common.ftl" as c>

<@c.page>
    <h4>${username}</h4>
    <form method="post">
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Пароль :
                <div class="col-sm-6">
                    <input type="password" name="password" class="form-control" placeholder="Пароль"/>
                </div>
            </label>
        </div>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Эл. почта
                <div class="col-sm-6">
                    <input type="email" name="email" class="form-control" placeholder="Эл.почта" value="${email}"/>
                </div>
            </label>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button class="btn btn-primary" type="submit">Сохранить</button>
        <br>
        <br>
        <br>
    </form>
</@c.page>