<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output indent="yes"/>

    <xsl:template match="/">
        <fo:root>

            <fo:layout-master-set>
                <fo:simple-page-master master-name="PageMaster" margin="25mm">
                    <fo:region-body/>
                    <fo:region-before/>
                    <fo:region-after/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="PageMaster">
                <fo:flow flow-name="xsl-region-body" line-height="1.5" font-size="12pt">
                    <fo:table>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/firstName"/>&#160;<xsl:value-of select="dismissalNotice/lastName"/>
                                    </fo:block>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/homeAddress/street"/>
                                    </fo:block>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/homeAddress/postalCode"/>&#160;<xsl:value-of select="dismissalNotice/homeAddress/city"/>
                                    </fo:block>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="right">
                                        <xsl:value-of select="dismissalNotice/dismissalPlace"/>, <xsl:value-of select="dismissalNotice/dismissalDate"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:table>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/companyName"/>
                                    </fo:block>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/companyAddress/street"/>
                                    </fo:block>
                                    <fo:block text-align="left">
                                        <xsl:value-of select="dismissalNotice/companyAddress/postalCode"/>&#160;<xsl:value-of select="dismissalNotice/companyAddress/city"/>
                                    </fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block text-align="center" font-size="14pt" font-weight="bold">Wypowiedzenie umowy o prace</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block text-align="justify">Niniejszym wypowiadam umowe o prace zawarta dnia
                        <xsl:value-of select="dismissalNotice/agreementDate"/> w <xsl:value-of select="dismissalNotice/companyAddress/city"/> pomiedzy
                        <xsl:value-of select="dismissalNotice/firstName"/>&#160;<xsl:value-of select="dismissalNotice/lastName"/> a
                        <xsl:value-of select="dismissalNotice/companyName"/> z zachowaniem okresu wypowiedzenia wynoszacego
                        <xsl:choose>
                            <xsl:when test="dismissalNotice/dismissalPeriod = 0.5">dwa tygodnie.</xsl:when>
                            <xsl:when test="dismissalNotice/dismissalPeriod = 1">jeden miesiac.</xsl:when>
                            <xsl:when test="dismissalNotice/dismissalPeriod = 3">trzy miesiace.</xsl:when>
                        </xsl:choose>
                    </fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:block>&#160;</fo:block>
                    <fo:table>
                        <fo:table-body>
                            <fo:table-row>
                                <fo:table-cell>
                                    <fo:block/>
                                </fo:table-cell>
                                <fo:table-cell>
                                    <fo:block text-align="left">z powazaniem</fo:block>
                                </fo:table-cell>
                            </fo:table-row>
                        </fo:table-body>
                    </fo:table>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

</xsl:stylesheet>