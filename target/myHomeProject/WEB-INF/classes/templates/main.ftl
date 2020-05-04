<#import "parts/common.ftl" as c>
<@c.page>
<div class="form-row">
<form method="get" action="/main">
    <input type="text" name="filter" >
    <button type="submit">Найти</button>
</form>
</div>
<div>
    <form method="post">
        <input type="text" name="name" placeholder="Введите имя" />
        <input type="text" name="number" placeholder="Введите телефон">
        <button type="submit">Добавить</button>
    </form>
</div>

<#list cups as cup>
<div>
    <b>${cup.id}</b>
    <span>${cup.name}</span>
    <i>${cup.number}</i>
</div>
<#else>
Номер не зарегестрирован!
</#list>
</@c.page>