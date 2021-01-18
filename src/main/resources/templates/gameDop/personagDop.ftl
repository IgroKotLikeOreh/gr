<table width="100%" height="100%" border="0" align="center" cellpadding="4" cellspacing="0">
    <tr>
        <#list personagesDop as personagDop>
            <td>
                <#if personagDop.getName()??>
                    <form method="post" >
                        <input type="hidden" name="persName" value="${personagDop.getName()}" />
                        <input type="hidden" name="_csrf" value="${_csrf.token}" />
                        <#if dopPers == true>
                            <button type="submit"
                                    style="border-style: double;
                                                                    border-width: medium;
                                                                    border-color: green;"
                                    border-color="#00ff00">
                                </button>
                        <#else>
                            <button type="submit" disabled="disabled" border="none">
                                </button>
                        </#if>
                    </form>
                </#if>
            </td>
        </#list>
    </tr>
</table>