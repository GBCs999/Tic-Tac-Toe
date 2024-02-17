#include<stdio.h>

void kiir (int a, int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int b, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9, int c, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int d, int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int e, int e1, int e2, int e3, int e4, int e5, int e6, int e7, int e8, int e9, int f, int f1, int f2, int f3, int f4, int f5, int f6, int f7, int f8, int f9, int g, int g1, int g2, int g3, int g4, int g5, int g6, int g7, int g8, int g9, int h, int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9);
int check (int win, int m1, int m2, int m3, int m4, int m5, int m6, int m7, int m8, int m9);
int beir ();


int main(){
    int a=0, a1=0, a2=0, a3=0, a4=0, a5=0, a6=0, a7=0, a8=0, a9=0;
    int b=0, b1=0, b2=0, b3=0, b4=0, b5=0, b6=0, b7=0, b8=0, b9=0;
    int c=0, c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0;
    int d=0, d1=0, d2=0, d3=0, d4=0, d5=0, d6=0, d7=0, d8=0, d9=0;
    int e=0, e1=0, e2=0, e3=0, e4=0, e5=0, e6=0, e7=0, e8=0, e9=0;
    int f=0, f1=0, f2=0, f3=0, f4=0, f5=0, f6=0, f7=0, f8=0, f9=0;
    int g=0, g1=0, g2=0, g3=0, g4=0, g5=0, g6=0, g7=0, g8=0, g9=0;
    int h=0, h1=0, h2=0, h3=0, h4=0, h5=0, h6=0, h7=0, h8=0, h9=0;
    int i=0, i1=0, i2=0, i3=0, i4=0, i5=0, i6=0, i7=0, i8=0, i9=0;
    int tabla=0;
    int mezo=0;
    int win=0, kor=1, ok=0, end=1;
    //0=üres, 1=X, 2=O, 3=-;
    do{
        printf("\nAz X jatekos kezd\n");
        do
        {
            kiir (a, a1, a2, a3, a4, a5, a6, a7, a8, a9, b, b1, b2, b3, b4, b5, b6, b7, b8, b9, c, c1, c2, c3, c4, c5, c6, c7, c8, c9, d, d1, d2, d3, d4, d5, d6, d7, d8, d9, e, e1, e2, e3, e4, e5, e6, e7, e8, e9, f, f1, f2, f3, f4, f5, f6, f7, f8, f9, g, g1, g2, g3, g4, g5, g6, g7, g8, g9, h, h1, h2, h3, h4, h5, h6, h7, h8, h9, i, i1, i2, i3, i4, i5, i6, i7, i8, i9);
            if(kor%2==0){
                printf("\nAz O jatekos kore jon\n");
            }
            else if(kor>1){
                printf("\nAz X jatekos kore jon\n");
            }
            do
            {
                switch (tabla)
                {
                case 1:
                    if(a==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(a1==0){
                                if(kor%2==0){
                                    a1=2;
                                }
                                else{
                                    a1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(a2==0){
                                if(kor%2==0){
                                    a2=2;
                                }
                                else{
                                    a2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(a3==0){
                                if(kor%2==0){
                                    a3=2;
                                }
                                else{
                                    a3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(a4==0){
                                if(kor%2==0){
                                    a4=2;
                                }
                                else{
                                    a4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(a5==0){
                                if(kor%2==0){
                                    a5=2;
                                }
                                else{
                                    a5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(a6==0){
                                if(kor%2==0){
                                    a6=2;
                                }
                                else{
                                    a6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(a7==0){
                                if(kor%2==0){
                                    a7=2;
                                }
                                else{
                                    a7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(a8==0){
                                if(kor%2==0){
                                    a8=2;
                                }
                                else{
                                    a8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(a9==0){
                                if(kor%2==0){
                                    a9=2;
                                }
                                else{
                                    a9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        a=check(a, a1, a2, a3, a4, a5, a6, a7, a8, a9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 2:
                    if(b==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(b1==0){
                                if(kor%2==0){
                                    b1=2;
                                }
                                else{
                                    b1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(b2==0){
                                if(kor%2==0){
                                    b2=2;
                                }
                                else{
                                    b2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(b3==0){
                                if(kor%2==0){
                                    b3=2;
                                }
                                else{
                                    b3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(b4==0){
                                if(kor%2==0){
                                    b4=2;
                                }
                                else{
                                    b4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(b5==0){
                                if(kor%2==0){
                                    b5=2;
                                }
                                else{
                                    b5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(b6==0){
                                if(kor%2==0){
                                    b6=2;
                                }
                                else{
                                    b6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(b7==0){
                                if(kor%2==0){
                                    b7=2;
                                }
                                else{
                                    b7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(b8==0){
                                if(kor%2==0){
                                    b8=2;
                                }
                                else{
                                    b8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(b9==0){
                                if(kor%2==0){
                                    b9=2;
                                }
                                else{
                                    b9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        b=check(b, b1, b2, b3, b4, b5, b6, b7, b8, b9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 3:
                    if(c==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(c1==0){
                                if(kor%2==0){
                                    c1=2;
                                }
                                else{
                                    c1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(c2==0){
                                if(kor%2==0){
                                    c2=2;
                                }
                                else{
                                    c2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(c3==0){
                                if(kor%2==0){
                                    c3=2;
                                }
                                else{
                                    c3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(c4==0){
                                if(kor%2==0){
                                    c4=2;
                                }
                                else{
                                    c4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(c5==0){
                                if(kor%2==0){
                                    c5=2;
                                }
                                else{
                                    c5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(c6==0){
                                if(kor%2==0){
                                    c6=2;
                                }
                                else{
                                    c6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(c7==0){
                                if(kor%2==0){
                                    c7=2;
                                }
                                else{
                                    c7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(c8==0){
                                if(kor%2==0){
                                    c8=2;
                                }
                                else{
                                    c8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(c9==0){
                                if(kor%2==0){
                                    c9=2;
                                }
                                else{
                                    c9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        c=check(c, c1, c2, c3, c4, c5, c6, c7, c8, c9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 4:
                    if(d==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(d1==0){
                                if(kor%2==0){
                                    d1=2;
                                }
                                else{
                                    d1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(d2==0){
                                if(kor%2==0){
                                    d2=2;
                                }
                                else{
                                    d2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(d3==0){
                                if(kor%2==0){
                                    d3=2;
                                }
                                else{
                                    d3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(d4==0){
                                if(kor%2==0){
                                    d4=2;
                                }
                                else{
                                    d4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(d5==0){
                                if(kor%2==0){
                                    d5=2;
                                }
                                else{
                                    d5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(d6==0){
                                if(kor%2==0){
                                    d6=2;
                                }
                                else{
                                    d6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(d7==0){
                                if(kor%2==0){
                                    d7=2;
                                }
                                else{
                                    d7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(d8==0){
                                if(kor%2==0){
                                    d8=2;
                                }
                                else{
                                    d8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(d9==0){
                                if(kor%2==0){
                                    d9=2;
                                }
                                else{
                                    d9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        d=check(d, d1, d2, d3, d4, d5, d6, d7, d8, d9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 5:
                    if(e==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(e1==0){
                                if(kor%2==0){
                                    e1=2;
                                }
                                else{
                                    e1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(e2==0){
                                if(kor%2==0){
                                    e2=2;
                                }
                                else{
                                    e2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(e3==0){
                                if(kor%2==0){
                                    e3=2;
                                }
                                else{
                                    e3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(e4==0){
                                if(kor%2==0){
                                    e4=2;
                                }
                                else{
                                    e4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(e5==0){
                                if(kor%2==0){
                                    e5=2;
                                }
                                else{
                                    e5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(e6==0){
                                if(kor%2==0){
                                    e6=2;
                                }
                                else{
                                    e6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(e7==0){
                                if(kor%2==0){
                                    e7=2;
                                }
                                else{
                                    e7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(e8==0){
                                if(kor%2==0){
                                    e8=2;
                                }
                                else{
                                    e8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(e9==0){
                                if(kor%2==0){
                                    e9=2;
                                }
                                else{
                                    e9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        e=check(e, e1, e2, e3, e4, e5, e6, e7, e8, e9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 6:
                    if(f==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(f1==0){
                                if(kor%2==0){
                                    f1=2;
                                }
                                else{
                                    f1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(f2==0){
                                if(kor%2==0){
                                    f2=2;
                                }
                                else{
                                    f2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(f3==0){
                                if(kor%2==0){
                                    f3=2;
                                }
                                else{
                                    f3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(f4==0){
                                if(kor%2==0){
                                    f4=2;
                                }
                                else{
                                    f4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(f5==0){
                                if(kor%2==0){
                                    f5=2;
                                }
                                else{
                                    f5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(f6==0){
                                if(kor%2==0){
                                    f6=2;
                                }
                                else{
                                    f6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(f7==0){
                                if(kor%2==0){
                                    f7=2;
                                }
                                else{
                                    f7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(f8==0){
                                if(kor%2==0){
                                    f8=2;
                                }
                                else{
                                    f8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(f9==0){
                                if(kor%2==0){
                                    f9=2;
                                }
                                else{
                                    f9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        f=check(f, f1, f2, f3, f4, f5, f6, f7, f8, f9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 7:
                    if(g==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(g1==0){
                                if(kor%2==0){
                                    g1=2;
                                }
                                else{
                                    g1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(g2==0){
                                if(kor%2==0){
                                    g2=2;
                                }
                                else{
                                    g2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(g3==0){
                                if(kor%2==0){
                                    g3=2;
                                }
                                else{
                                    g3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(g4==0){
                                if(kor%2==0){
                                    g4=2;
                                }
                                else{
                                    g4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(g5==0){
                                if(kor%2==0){
                                    g5=2;
                                }
                                else{
                                    g5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(g6==0){
                                if(kor%2==0){
                                    g6=2;
                                }
                                else{
                                    g6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(g7==0){
                                if(kor%2==0){
                                    g7=2;
                                }
                                else{
                                    g7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(g8==0){
                                if(kor%2==0){
                                    g8=2;
                                }
                                else{
                                    g8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(g9==0){
                                if(kor%2==0){
                                    g9=2;
                                }
                                else{
                                    g9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                    
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        g=check(g, g1, g2, g3, g4, g5, g6, g7, g8, g9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 8:
                    if(h==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(h1==0){
                                if(kor%2==0){
                                    h1=2;
                                }
                                else{
                                    h1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(h2==0){
                                if(kor%2==0){
                                    h2=2;
                                }
                                else{
                                    h2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(h3==0){
                                if(kor%2==0){
                                    h3=2;
                                }
                                else{
                                    h3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(h4==0){
                                if(kor%2==0){
                                    h4=2;
                                }
                                else{
                                    h4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(h5==0){
                                if(kor%2==0){
                                    h5=2;
                                }
                                else{
                                    h5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(h6==0){
                                if(kor%2==0){
                                    h6=2;
                                }
                                else{
                                    h6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(h7==0){
                                if(kor%2==0){
                                    h7=2;
                                }
                                else{
                                    h7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(h8==0){
                                if(kor%2==0){
                                    h8=2;
                                }
                                else{
                                    h8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(h9==0){
                                if(kor%2==0){
                                    h9=2;
                                }
                                else{
                                    h9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        h=check(h, h1, h2, h3, h4, h5, h6, h7, h8, h9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                case 9:
                    if(i==0){
                        printf("Adja meg a kivalasztott mezo szamat: ");
                        mezo=beir();
                        switch (mezo)
                        {
                        case 1:
                            if(i1==0){
                                if(kor%2==0){
                                    i1=2;
                                }
                                else{
                                    i1=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 2:
                            if(i2==0){
                                if(kor%2==0){
                                    i2=2;
                                }
                                else{
                                    i2=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 3:
                            if(i3==0){
                                if(kor%2==0){
                                    i3=2;
                                }
                                else{
                                    i3=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 4:
                            if(i4==0){
                                if(kor%2==0){
                                    i4=2;
                                }
                                else{
                                    i4=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 5:
                            if(i5==0){
                                if(kor%2==0){
                                    i5=2;
                                }
                                else{
                                    i5=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 6:
                            if(i6==0){
                                if(kor%2==0){
                                    i6=2;
                                }
                                else{
                                    i6=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 7:
                            if(i7==0){
                                if(kor%2==0){
                                    i7=2;
                                }
                                else{
                                    i7=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 8:
                            if(i8==0){
                                if(kor%2==0){
                                    i8=2;
                                }
                                else{
                                    i8=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        case 9:
                            if(i9==0){
                                if(kor%2==0){
                                    i9=2;
                                }
                                else{
                                    i9=1;
                                }
                                ok=1;
                            }
                            else{
                                printf("A mezo foglalt");
                            }
                            break;
                        default:
                            printf("\nEz a mezo szam nem letezik, 1-tol 9ig valasszon\n");
                            break;
                        }
                        i=check(i, i1, i2, i3, i4, i5, i6, i7, i8, i9);
                    }
                    else{
                        printf("Az alabbi tablazat betelt\n");
                        tabla=0;
                    }
                    break;
                default:
                    printf("\nAdja meg hanyas tablaba kivan tenni: ");
                    tabla=beir();
                    break;
                }
            } while (ok==0);
            kor++;
            ok=0;
            tabla=mezo;
            win=check(win, a, b, c, d, e, f, g, h, i);
        } while (win==0);
        kiir (a, a1, a2, a3, a4, a5, a6, a7, a8, a9, b, b1, b2, b3, b4, b5, b6, b7, b8, b9, c, c1, c2, c3, c4, c5, c6, c7, c8, c9, d, d1, d2, d3, d4, d5, d6, d7, d8, d9, e, e1, e2, e3, e4, e5, e6, e7, e8, e9, f, f1, f2, f3, f4, f5, f6, f7, f8, f9, g, g1, g2, g3, g4, g5, g6, g7, g8, g9, h, h1, h2, h3, h4, h5, h6, h7, h8, h9, i, i1, i2, i3, i4, i5, i6, i7, i8, i9);
        if (win==1){
            printf("\nAz X jatekos nyert\n");
        }
        else if (win==2){
            printf("\nAz O jatekos nyert\n");
        }
        else{
            printf("\nSenki sem nyert\n");
        }
        printf("\nHa ujra kivannak jatszani nyomjak meg az 1-est, ha nem, akkor nyomjanak meg barmilyen mas karaktert");
        scanf("%d", &end);
        if(end==1){
            a=0, a1=0, a2=0, a3=0, a4=0, a5=0, a6=0, a7=0, a8=0, a9=0, b=0, b1=0, b2=0, b3=0, b4=0, b5=0, b6=0, b7=0, b8=0, b9=0, c=0, c1=0, c2=0, c3=0, c4=0, c5=0, c6=0, c7=0, c8=0, c9=0, d=0, d1=0, d2=0, d3=0, d4=0, d5=0, d6=0, d7=0, d8=0, d9=0, e=0, e1=0, e2=0, e3=0, e4=0, e5=0, e6=0, e7=0, e8=0, e9=0; f=0, f1=0, f2=0, f3=0, f4=0, f5=0, f6=0, f7=0, f8=0, f9=0, g=0, g1=0, g2=0, g3=0, g4=0, g5=0, g6=0, g7=0, g8=0, g9=0, h=0, h1=0, h2=0, h3=0, h4=0, h5=0, h6=0, h7=0, h8=0, h9=0, i=0, i1=0, i2=0, i3=0, i4=0, i5=0, i6=0, i7=0, i8=0, i9=0, tabla=0, mezo=0, win=0, kor=1, ok=0, end=1;
        }
    }while(end==1);
    
    return 0;
}

void kiir (int a, int a1, int a2, int a3, int a4, int a5, int a6, int a7, int a8, int a9, int b, int b1, int b2, int b3, int b4, int b5, int b6, int b7, int b8, int b9, int c, int c1, int c2, int c3, int c4, int c5, int c6, int c7, int c8, int c9, int d, int d1, int d2, int d3, int d4, int d5, int d6, int d7, int d8, int d9, int e, int e1, int e2, int e3, int e4, int e5, int e6, int e7, int e8, int e9, int f, int f1, int f2, int f3, int f4, int f5, int f6, int f7, int f8, int f9, int g, int g1, int g2, int g3, int g4, int g5, int g6, int g7, int g8, int g9, int h, int h1, int h2, int h3, int h4, int h5, int h6, int h7, int h8, int h9, int i, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9){
    printf("\n");
    if(a1==1){
        printf("X");
    }
    else if(a1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(a2==1){
        printf("X");
    }
    else if(a2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(a3==1){
        printf("X");
    }
    else if(a3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(b1==1){
        printf("X");
    }
    else if(b1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(b2==1){
        printf("X");
    }
    else if(b2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(b3==1){
        printf("X");
    }
    else if(b3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(c1==1){
        printf("X");
    }
    else if(c1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(c2==1){
        printf("X");
    }
    else if(c2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(c3==1){
        printf("X");
    }
    else if(c3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("    ");
    if(a==0){
        printf("1");
    }
    else if(a==1){
        printf("X");
    }
    else if(a==2){
        printf("O");
    }
    else if(a==3){
        printf("-");
    }
    printf("|");
    if(b==0){
        printf("2");
    }
    else if(b==1){
        printf("X");
    }
    else if(b==2){
        printf("O");
    }
    else if(b==3){
        printf("-");
    }
    printf("|");
    if(c==0){
        printf("3");
    }
    else if(c==1){
        printf("X");
    }
    else if(c==2){
        printf("O");
    }
    else if(c==3){
        printf("-");
    }
    printf("\n");
    if(a4==1){
        printf("X");
    }
    else if(a4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(a5==1){
        printf("X");
    }
    else if(a5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(a6==1){
        printf("X");
    }
    else if(a6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(b4==1){
        printf("X");
    }
    else if(b4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(b5==1){
        printf("X");
    }
    else if(b5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(b6==1){
        printf("X");
    }
    else if(b6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(c4==1){
        printf("X");
    }
    else if(c4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(c5==1){
        printf("X");
    }
    else if(c5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(c6==1){
        printf("X");
    }
    else if(c6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("    -----\n");
    if(a7==1){
        printf("X");
    }
    else if(a7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(a8==1){
        printf("X");
    }
    else if(a8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(a9==1){
        printf("X");
    }
    else if(a9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(b7==1){
        printf("X");
    }
    else if(b7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(b8==1){
        printf("X");
    }
    else if(b8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(b9==1){
        printf("X");
    }
    else if(b9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(c7==1){
        printf("X");
    }
    else if(c7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(c8==1){
        printf("X");
    }
    else if(c8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(c9==1){
        printf("X");
    }
    else if(c9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("    ");
    if(d==0){
        printf("4");
    }
    else if(d==1){
        printf("X");
    }
    else if(d==2){
        printf("O");
    }
    else if(d==3){
        printf("-");
    }
    printf("|");
    if(e==0){
        printf("5");
    }
    else if(e==1){
        printf("X");
    }
    else if(e==2){
        printf("O");
    }
    else if(e==3){
        printf("-");
    }
    printf("|");
    if(f==0){
        printf("6");
    }
    else if(f==1){
        printf("X");
    }
    else if(f==2){
        printf("O");
    }
    else if(f==3){
        printf("-");
    }
    printf("\n-----------    -----\n");
    if(d1==1){
        printf("X");
    }
    else if(d1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(d2==1){
        printf("X");
    }
    else if(d2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(d3==1){
        printf("X");
    }
    else if(d3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(e1==1){
        printf("X");
    }
    else if(e1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(e2==1){
        printf("X");
    }
    else if(e2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(e3==1){
        printf("X");
    }
    else if(e3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(f1==1){
        printf("X");
    }
    else if(f1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(f2==1){
        printf("X");
    }
    else if(f2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(f3==1){
        printf("X");
    }
    else if(f3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("    ");
    if(g==0){
        printf("7");
    }
    else if(g==1){
        printf("X");
    }
    else if(g==2){
        printf("O");
    }
    else if(g==3){
        printf("-");
    }
    printf("|");
    if(h==0){
        printf("8");
    }
    else if(h==1){
        printf("X");
    }
    else if(h==2){
        printf("O");
    }
    else if(h==3){
        printf("-");
    }
    printf("|");
    if(i==0){
        printf("9");
    }
    else if(i==1){
        printf("X");
    }
    else if(i==2){
        printf("O");
    }
    else if(i==3){
        printf("-");
    }
    printf("\n");
    if(d4==1){
        printf("X");
    }
    else if(d4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(d5==1){
        printf("X");
    }
    else if(d5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(d6==1){
        printf("X");
    }
    else if(d6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(e4==1){
        printf("X");
    }
    else if(e4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(e5==1){
        printf("X");
    }
    else if(e5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(e6==1){
        printf("X");
    }
    else if(e6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(f4==1){
        printf("X");
    }
    else if(f4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(f5==1){
        printf("X");
    }
    else if(f5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(f6==1){
        printf("X");
    }
    else if(f6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("\n");
    if(d7==1){
        printf("X");
    }
    else if(d7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(d8==1){
        printf("X");
    }
    else if(d8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(d9==1){
        printf("X");
    }
    else if(d9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(e7==1){
        printf("X");
    }
    else if(e7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(e8==1){
        printf("X");
    }
    else if(e8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(e9==1){
        printf("X");
    }
    else if(e9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(f7==1){
        printf("X");
    }
    else if(f7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(f8==1){
        printf("X");
    }
    else if(f8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(f9==1){
        printf("X");
    }
    else if(f9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("\n-----------\n");
    if(g1==1){
        printf("X");
    }
    else if(g1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(g2==1){
        printf("X");
    }
    else if(g2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(g3==1){
        printf("X");
    }
    else if(g3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(h1==1){
        printf("X");
    }
    else if(h1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(h2==1){
        printf("X");
    }
    else if(h2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(h3==1){
        printf("X");
    }
    else if(h3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("|");
    if(i1==1){
        printf("X");
    }
    else if(i1==2){
        printf("O");
    }
    else{
        printf("1");
    }
    if(i2==1){
        printf("X");
    }
    else if(i2==2){
        printf("O");
    }
    else{
        printf("2");
    }
    if(i3==1){
        printf("X");
    }
    else if(i3==2){
        printf("O");
    }
    else{
        printf("3");
    }
    printf("\n");
    if(g4==1){
        printf("X");
    }
    else if(g4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(g5==1){
        printf("X");
    }
    else if(g5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(g6==1){
        printf("X");
    }
    else if(g6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(h4==1){
        printf("X");
    }
    else if(h4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(h5==1){
        printf("X");
    }
    else if(h5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(h6==1){
        printf("X");
    }
    else if(h6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("|");
    if(i4==1){
        printf("X");
    }
    else if(i4==2){
        printf("O");
    }
    else{
        printf("4");
    }
    if(i5==1){
        printf("X");
    }
    else if(i5==2){
        printf("O");
    }
    else{
        printf("5");
    }
    if(i6==1){
        printf("X");
    }
    else if(i6==2){
        printf("O");
    }
    else{
        printf("6");
    }
    printf("\n");
    if(g7==1){
        printf("X");
    }
    else if(g7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(g8==1){
        printf("X");
    }
    else if(g8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(g9==1){
        printf("X");
    }
    else if(g9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(h7==1){
        printf("X");
    }
    else if(h7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(h8==1){
        printf("X");
    }
    else if(h8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(h9==1){
        printf("X");
    }
    else if(h9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("|");
    if(i7==1){
        printf("X");
    }
    else if(i7==2){
        printf("O");
    }
    else{
        printf("7");
    }
    if(i8==1){
        printf("X");
    }
    else if(i8==2){
        printf("O");
    }
    else{
        printf("8");
    }
    if(i9==1){
        printf("X");
    }
    else if(i9==2){
        printf("O");
    }
    else{
        printf("9");
    }
    printf("\n\n");
}
int check (int win, int m1, int m2, int m3, int m4, int m5, int m6, int m7, int m8, int m9){
    if (win==0){
        if(m1==m2 && m2==m3){
            if(m1==1 || m1==2)
                return m1;
        }
        if(m4==m5 && m5==m5){
            if(m4==1 || m4==2)
                return m4;
        }
        if(m7==m8 && m8==m9){
            if(m7==1 || m7==2)
                return m7;
        }
        if(m1==m4 && m4==m7){
            if(m1==1 || m1==2)
                return m1;
        }
        if(m2==m5 && m5==m8){
            if(m2==1 || m2==2)
                return m2;
        }
        if(m3==m6 && m6==m9){
            if(m3==1 || m3==2)
                return m3;
        }
        if(m1==m5 && m5==m9){
            if(m1==1 || m1==2)
                return m1;
        }
        if(m3==m5 && m5==m7){
            if(m3==1 || m3==2)
                return m3;
        }
        if(m1!=0 && m2!=0 && m3!=0 && m4!=0 && m5!=0 && m6!=0 && m7!=0 && m8!=0 && m9!=0){
                return 3;
        }
    }
    return win;
}
int beir (){
    int a=0, ok=0;
    char ch;
    do{
        if(scanf("%d", &a)!=1){
            printf("Hibas ertek\n");
            while ((ch=getchar())!='\n');
        }
        else if(1<=a && a<=9)
            ok=1;
        else
            printf("A valasztott ertek legyen 1 es 9 kozott\n");
    }while(ok!=1);
    return a;
}