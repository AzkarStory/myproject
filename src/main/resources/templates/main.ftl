<#import "parts/common.ftl" as c>
<@c.page>
<div class="form-row">
    <div class = "form-group col-md-6">
        <form method="get" action="/main" class="form-inline">
            <input type="text" name="filter" class="form-control" value="${filter?ifExists}" placeholder="Поиск по номеру">
            <button type="submit" class="btn btn-primary ml-2">Найти</button>
        </form>
    </div>
</div>
<div class="form-row">
    <div class = "form-group col-md-6">
        <form method="post">
            <input type="text" name="name" class="form-control" placeholder="Введите имя" />
            <input type="text" name="number" class="form-control mt-2" placeholder="Введите телефон">
            <button type="submit" class="btn btn-primary mt-2">Добавить</button>
        </form>
    </div>
</div>
<#list cups as cup>
<ul class="list-group">
    <li class="list-group-item active mt-2">${cup.id}</li>
    <li class="list-group-item">Имя: ${cup.name}</li>
    <li class="list-group-item">Номер телефона: ${cup.number}</li>
    <li class="list-group-item">Количество кружек: ${cup.cup}</li>
    <li class="list-group-item">Запасных кружек: ${cup.cupZapas}</li>
    <li class="list-group-item">Всего выпито кружек: ${cup.totalCup}</li>


    <form method="post" action="/main/update">
        <input type="hidden" name="id" value="${cup.id}">
        <input type="hidden" name="name" value="${cup.name}">
        <input type="hidden" name="number" value="${cup.number}">
        <input type="hidden" name="cup" value="${cup.cup}">
        <input type="hidden" name="cupzapas" value="${cup.cupZapas}">
        <input type="hidden" name="totalcup" value="${cup.totalCup}">
        <button type="submit" class="btn btn-primary mt-2">Добавить кружку</button>
    </form>
    <form method="post" action="/main/free">
        <input type="hidden" name="id" value="${cup.id}">
        <input type="hidden" name="name" value="${cup.name}">
        <input type="hidden" name="number" value="${cup.number}">
        <input type="hidden" name="cup" value="${cup.cup}">
        <input type="hidden" name="cupzapas" value="${cup.cupZapas}">
        <input type="hidden" name="totalcup" value="${cup.totalCup}">
        <button type="submit" class="btn btn-primary mt-2">Использовать бесплатную кружку</button>
    </form>
    <form method="post" action="/main/zapas">
        <input type="hidden" name="id" value="${cup.id}">
        <input type="hidden" name="name" value="${cup.name}">
        <input type="hidden" name="number" value="${cup.number}">
        <input type="hidden" name="cup" value="${cup.cup}">
        <input type="hidden" name="cupzapas" value="${cup.cupZapas}">
        <input type="hidden" name="totalcup" value="${cup.totalCup}">
        <button type="submit" class="btn btn-primary mt-2">Добавить запасную кружку</button>
    </form>
</ul>

<#else>
Номер не зарегестрирован!
</#list>
</@c.page>