<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <style>
          h1{text-align:center}
          table{
            background-color:#BCF5A9;
            border-style: solid;
            border-width: 1px;
            margin:auto;
            width:80%;
            text-align:center;
          }
          .cabeza{
            font-weight: bold;
          }
        </style>
      </head>
      <body>
      <h1>EMPLEADOS</h1>
        <table>
          <tr>
            <td class="cabeza">Dni_Emple</td>
            <td class="cabeza">Nombre</td>
            <td class="cabeza">F_Nacimiento</td>
            <td class="cabeza">Tfno_Contacto</td>
            <td class="cabeza">Alta_Club</td>
            <td class="cabeza">Cuenta_Bancaria</td>
            <td class="cabeza">Cargo</td>
            <td class="cabeza">Correo</td>
          </tr>
          <xsl:for-each select="database/table">
            <xsl:if test="@name='empleados'">
              <xsl:if test="column='Entrenador'">
                <tr>
                  <td style="color:red"><xsl:value-of select="column[@name='Dni_Emple']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Nombre']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='F_Nacimiento']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Tfno_Contacto']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Alta_Club']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Cuenta_Bancaria']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Cargo']"/></td>
                  <td style="color:red"><xsl:value-of select="column[@name='Correo']"/></td>
                </tr>
              </xsl:if>
              <tr>
                  <td><xsl:value-of select="column[@name='Dni_Emple']"/></td>
                  <td><xsl:value-of select="column[@name='Nombre']"/></td>
                  <td><xsl:value-of select="column[@name='F_Nacimiento']"/></td>
                  <td><xsl:value-of select="column[@name='Tfno_Contacto']"/></td>
                  <td><xsl:value-of select="column[@name='Alta_Club']"/></td>
                  <td><xsl:value-of select="column[@name='Cuenta_Bancaria']"/></td>
                  <td><xsl:value-of select="column[@name='Cargo']"/></td>
                  <td><xsl:value-of select="column[@name='Correo']"/></td>
                </tr>

            </xsl:if>
          </xsl:for-each>
        </table>
        <br/><br/>
        <h1>JUGADORES</h1>
        <table>
          <tr>
            <td class="cabeza">Dni_Emple</td>
            <td class="cabeza">Nombre</td>
            <td class="cabeza">F_Nacimiento</td>
            <td class="cabeza">Tfno_Contacto</td>
            <td class="cabeza">Alta_Club</td>
            <td class="cabeza">Cuenta_Bancaria</td>
            <td class="cabeza">Demarcacion</td>
            <td class="cabeza">Correo</td>
            <td class="cabeza">Lesionado</td>
          </tr>
          <xsl:for-each select="database/table">
            <xsl:if test="@name='jugadores'">
              <tr>
                <td><xsl:value-of select="column[@name='Dni_Jugador']"/></td>
                <td><xsl:value-of select="column[@name='Nombre']"/></td>
                <td><xsl:value-of select="column[@name='F_Nacimiento']"/></td>
                <td><xsl:value-of select="column[@name='Tfno_Contacto']"/></td>
                <td><xsl:value-of select="column[@name='Alta_Club']"/></td>
                <td><xsl:value-of select="column[@name='Cuenta_Bancaria']"/></td>
                <td><xsl:value-of select="column[@name='Demarcacion']"/></td>
                <td><xsl:value-of select="column[@name='Correo']"/></td>
                <td><xsl:value-of select="column[@name='Lesionado']"/></td>
              </tr>
            </xsl:if>
          </xsl:for-each>
        </table>
        <br/><br/>
        <h1>AVISOS</h1>
        <table>
          <tr>
            <td class="cabeza">N_Aviso</td>
            <td class="cabeza">Dni_emple</td>
            <td class="cabeza">Motivo</td>
            <td class="cabeza">FH_Creacion</td>
            <td class="cabeza">FH_Leido</td>
          </tr>
          <xsl:for-each select="database/table">
            <xsl:if test="@name='avisos'">
              <tr>
                <td><xsl:value-of select="column[@name='N_Aviso']"/></td>
                <td><xsl:value-of select="column[@name='Dni_emple']"/></td>
                <td><xsl:value-of select="column[@name='Motivo']"/></td>
                <td><xsl:value-of select="column[@name='FH_Creacion']"/></td>
                <td><xsl:value-of select="column[@name='FH_Leido']"/></td>
              </tr>
            </xsl:if>
          </xsl:for-each>
        </table>
        <br/><br/>
        <h1>DESTINATARIOS DE AVISOS</h1>
        <table>
          <tr>
            <td class="cabeza">N_Aviso</td>
            <td class="cabeza">Destinatario</td>
          </tr>
          <xsl:for-each select="database/table">
            <xsl:if test="@name='avisos_dest'">
              <tr>
                <td><xsl:value-of select="column[@name='N_Aviso']"/></td>
                <td><xsl:value-of select="column[@name='Destinatario']"/></td>
              </tr>
            </xsl:if>
          </xsl:for-each>
        </table>
        <br/><br/>
        <h1>SESIONES</h1>
        <table>
          <tr>
            <td class="cabeza">Dni_Jugador</td>
            <td class="cabeza">Dni_emple</td>
            <td class="cabeza">FH_Sesion</td>
            <td class="cabeza">Motivo</td>
            <td class="cabeza">Diagnostico</td>
          </tr>
          <xsl:for-each select="database/table">
            <xsl:if test="@name='sesion'">
              <tr>
                <td><xsl:value-of select="column[@name='Dni_Jugador']"/></td>
                <td><xsl:value-of select="column[@name='Dni_emple']"/></td>
                <td><xsl:value-of select="column[@name='FH_Sesion']"/></td>
                <td><xsl:value-of select="column[@name='Motivo']"/></td>
                <td><xsl:value-of select="column[@name='Diagnostico']"/></td>
              </tr>
            </xsl:if>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
