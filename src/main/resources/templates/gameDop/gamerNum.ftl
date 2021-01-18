<#assign gamer = gamers[num]>
<div>
${gamer.getName()}
</div>
<table width="100%" height="100%" border="0">
    <tr><td>
    <table width="80%" height="100%">

        <#list gamer.getPers() as personagRow>
            <tr>
                <div>
                    <#list personagRow as personag>
                    <td width="33%">
                        <#if personag.isNameFile()>
                        <form method="post" >
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <input type="hidden" name="persName" value="${personag.getName()}" />
                            <button type="submit" width="100%"><img src="https://mynewup.s3-ap-southeast-1.amazonaws.com/game/${personag.getName()}.png" height="100%" width="100%"/></button>
                        </form>
                        </#if>
                    </td>
                    </#list>
                </div>
            </tr>
        </#list>
    </table>
</td><td>
    <table height="100%">
        <#list gamer.kk() as dom, win>
            <tr><td width="100%">
                <div>
                    <#if win>
                        <form method="post" >
                            <input type="hidden" name="_csrf" value="${_csrf.token}" />
                            <button type="submit" width="100%" height="100%"><img src="https://mynewup.s3-ap-southeast-1.amazonaws.com/game/${dom}.png" height="100%" width="100%"/></button>
                        </form>
                    </#if>
                </div>
                </td></tr>

        </#list>
    </table>

</td>
</tr>
</table>
