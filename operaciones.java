Nodo S() :
{}
{
    
    hijo = exp()<EOF>{return hijo;} 
}

Nodo exp():{Nodo hijo hijoS;}
{
    hijo = and() hijoS = expp(hijo){return hijoS;}
}

Nodo expp(Nodo padre):{Nodo abuelo = new Nodo("exp"), hijo , hijoS;Token t1;}{
    t1 = <OR> hijo = and() { abuelo.addHijo(padre,new  Nodo(t1),hijo); } hijoS = expp(abuelo){return hijoS;}
    | {return padre;}
}

Nodo and():{Nodo hijo,hijoS;}{
    hijo = not() hijoS = andd(hijo){return hijoS;}
}

Nodo andd(Nodo padre):{Nodo abuelo = new Nodo("exp"),hijo,hijoS; Token t1, t2, t3;}{
    t1 = <AND> hijo = not() {abuelo.addHijo(padre,new Nodo(t1),hijo)} hijoS = andd(abuelo){ return hijoS; }
    |{return padre;}
}
//ya
Nodo not():{Nodo hijo,padre = new Nodo("exp"); Token t1;}{
    t1 = <NOT> hijo = relacional() {padre.hijo.add(new Nodo(t1));padre.hijo.add(hijo);return padre;}
    |hijo = relacional(){return hijo;}
}
//ya
Nodo relacional():{Nodo hijo ,hijoS;}{
    hijo = aritmetica() hijoS = relacionalp(hijo){return hijoS;}
}
//ya
Nodo relacionalp(Nodo padre):{Nodo hijo,abuelo = new Nodo("exp"),hijoS; Token t1}{
    t1 =<IGUALIGUAL>   hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |t1 = <NOTIGUAL>   hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |t1 = <MAYORQUE>   hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |t1 = <MENORQUE>   hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |t1 = <MAYORIGUAL> hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |t1 = <MENORIGUAL> hijo = aritmetica(){abuelo.addHijo(padre, new Nodo(t1), hijo);} hijoS = relacionalp(padre){return hijoS;}
    |{return padre;}
}
//ya
Nodo aritmetica():{Nodo hijo,hijoS}{
    hijo = armd() hijoS = aritmeticap(hijo){return hijoS;}
}
//ya
Nodo aritmeticap(Nodo padre):{Nodo hijo = new Nodo("exp"),abuelo = new Nodo("exp"),hijoS;Token t1, t2, t3;}{
      t1 = <MAS>  hijo = armd(){abuelo.addHijo(padre,new Nodo (t1),hijo);} hijoS = aritmeticap(abuelo){return hijoS;}
    |t1 = <MENOS> hijo = armd(){abuelo.addHijo(padre,new Nodo (t1),hijo);} hijoS = aritmeticap(abuelo){return hijoS;}
    |{return padre;}
}
//ya
Nodo armd():{Nodo hijo, hijoS;}{
    hijo = arExp() hijoS = armdp(hijo){return hijoS;}
}
//ya
Nodo armdp(Nodo padre):{Nodo hijo = new Nodo("exp"),hijoS, abuelo = new Nodo("exp");Token t1, t2, t3;}{
     t1 = <POR> hijo = arExp() {abuelo.addHijo(padre,new Nodo (t1),hijo);} hijoS = armdp(abuelo){return hijoS;}
    |t1 = <DIV> hijo = arExp() {abuelo.addHijo(padre,new Nodo (t1),hijo);} hijoS = armdp(abuelo){return hijoS;}
    |{return padre;}
}
//ya
Nodo arExp():{Nodo hijo = new Nodo("exp"),hijoS;}{
    hijo = arUnario() hijoS = arExpp(hijo){return hijoS;}
}
//ya
Nodo arExpp(Nodo padre):{Nodo hijo = new Nodo("exp"),abuelo = new Nodo("exp"),hijoS;Token t1, t2, t3;}{
    t1 = <ELEVA> hijo = arUnario() {abuelo.addHijo(padre,new Nodo(t1),hijo);} hijoS = arExpp(abuelo){return hijoS;}
    |{return padre;}
}

//ya
Nodo arUnario():{Nodo hijo,hijo2,padre = new Nodo("exp"); Token t1, t2, t3;}{
    t1 = <MENOS> hijo = valores(){padre.hijo.add(new Nodo(t1));padre.hijo.add(hijo);return padre;}
    |hijo = valores(){return hijo;}
}
//ya
Nodo valores():{Nodo hijo = new Nodo("exp"); Token t1, t2, t3;}{
    t1 = <NUM>        {hijo.hijo.add(new Nodo(t1));return hijo;}
    |t1 = <FECHA>     {hijo.hijo.add(new Nodo(t1));return hijo;}
    |t1 = <FECHA_HORA>{hijo.hijo.add(new Nodo(t1));return hijo;}
    |t1 = <DECIMAL>   {hijo.hijo.add(new Nodo(t1));return hijo;}
    |t1 = <CADENA>    {hijo.hijo.add(new Nodo(t1));return hijo;}
    |t1 = <ID>        {hijo.hijo.add(new Nodo(t1));return hijo;}
}