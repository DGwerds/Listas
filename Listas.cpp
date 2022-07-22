#include <iostream>
#include <stdlib.h> 
//#include <vector> // insert
using namespace std;

int cant;

void mostrar_lista(int lista[]){
	for (int i = 0; i < 5; i++){
		cout << lista[i] << ", ";
	}
}

void salir(int num){
	if (num == 1){
		exit(1);
	}
}

int main(){
	setlocale(LC_ALL,"spanish");
	cout << "Ingrese la cantidad de elementos: ";
	int lista[cant];
	bool error;
	(cin >> cant) ? error=false : error=true and cout<<"Porfavor ingresa un numero"<<endl<<"Finalizando programa...";
	(!error) ? salir(0) : salir(1);
	mostrar_lista(lista);
}
