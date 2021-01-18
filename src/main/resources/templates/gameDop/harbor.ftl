<div>
    <table width="100%" height="100%" border="0" align="center" cellpadding="4" cellspacing="0">

    <#list matrixPersonag as personagRow>
    <tr>
        <div>
            <#list personagRow as personag>
            <td>
                <#if personag.isNameFile()>
                <form method="post" >
                    <input type="hidden" name="persX" value="${personag.getX()}" />
                    <input type="hidden" name="persY" value="${personag.getY()}" />
                    <input type="hidden" name="_csrf" value="${_csrf.token}" />
                    <#if personag.getLig()>
                        <button type="submit"
                                style="border-style: double;
                                                                border-width: medium;
                                                                border-color: green;"
                                border-color="#00ff00">
                            <img src="/img/${personag.getName()}.png"
                                 height="100%" width="100%"  border="middle" bgcolor="#ffcc33" />
                        </button>
                    <#else>
                        <button type="submit" disabled="disabled" border="none">
                            <img src="/img/${personag.getName()}.png"
                                 height="100%" width="100%"/>
                        </button>
                    </#if>
                </form>
            </#if>
            </td>
        </#list>
        </div>
    </tr>
</#list>

</table>
</div>