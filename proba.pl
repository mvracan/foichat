change(lp,[foi1,prizemlje,dvorana,6]).
change(prog1,[foi1,drugi,kat,dvorana,1]).
change(sp,[foi1,drugi,kat,dvorana,3]).
change('Zlatka Stapica','foi1, drugi kat, kabinet broj 55').
change('Sandre Lovrencic','foi2, drugi kat kabinet broj 160').

change(je,"").
change(gdje,"Na").
change(predavanje,"").
change(kabinet,"").

change(X,X).
alter([],[]).

alter([H|T],[X|Y]):-change(H,X),
		    alter(T,Y),!.

