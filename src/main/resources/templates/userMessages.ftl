<#import "parts/common.ftl" as c>

<@c.page>
    <h3>${userChannel.username}</h3>

    <#if !isCurrentUser>
        <#if isSubscriber>
            <a href="/user/unsubscribe/${userChannel.id}" class="btn btn-danger m-4">Отписаться</a>
        <#else>
            <a href="/user/subscribe/${userChannel.id}" class="btn btn-primary m-4">Подписаться</a>
        </#if>
    </#if>
    <div class="container m-4   ">
        <div class="row">
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Подписки</div>
                        <h4 class="card-text">
                            <a href="/user/subscriptions/${userChannel.id}/list">${subscriptionsCount}</a>
                        </h4>
                    </div>
                </div>
            </div>
            <div class="col">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">Подписчики</div>
                        <h4 class="card-text">
                            <a href="/user/subscribers/${userChannel.id}/list">${subscribersCount}</a>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <#if isCurrentUser>
        <#include "parts/messageEdit.ftl" />
    </#if>
    <#include "parts/messageList.ftl" />
</@c.page>