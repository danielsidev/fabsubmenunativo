

<h1 align="center">Android Floating Action Button Submenu Custom</h1>
<p align="center">
  <img width="200"  src="https://raw.githubusercontent.com/danielsidev/fabsubmenunativo/master/app/src/main/res/drawable/screenshot/Screenshot_20180402-194231.png">
</p>
Um modelo para criar um submenu para o FLoating Action Button  e trocar a cor do botão desejado.

### Download para teste:


* Criei esse projeto simples para exemplificar o uso. Basta baixá-lo e executá-lo no Android Studio. Nesse exemplo é simulado a criação do menu com ações para Toast, Activity e Fragment.



### Instruções
----------
* Suporte ao SDK a partir da versão 15.


*Exemplos de utilização:*
----------

```
/* NO XML:
  Crie os elementos FloatingActionButton no xml principal da sua aplicação.
  Utilize os Floating Action Buttons do xml do exemplo como modelo para outros projetos.
 */

/* Importe a classe do package model */
import com.br.fabsubmenunativo.model.FabSubmenu;


/*
 Declare, os  Floating Action Buttons
 e um ArrayList de FloatingActionButton;

 @param FloatingActionButton fab
 @param ArrayList<FloatingActionButton> submenu
*/

FloatingActionButton fab, fabsub1, fabsub2, fabsub3;
ArrayList<FloatingActionButton> submenuFab = new ArrayList<>();

/* No onCreate  faça: */

/*---------- Preparando os botões FAB | Ini  ----------*/

fab = (FloatingActionButton) findViewById(R.id.fabCustom);
fabsub1 = (FloatingActionButton) findViewById(R.id.fabsub1);
fabsub2 = (FloatingActionButton) findViewById(R.id.fabsub2);
fabsub3 = (FloatingActionButton) findViewById(R.id.fabsub3);

/*Criando a lista do menu*/
submenuFab.add(fabsub1);
submenuFab.add(fabsub2);
submenuFab.add(fabsub3);

/* Para Fragment use o rootView: View rootView = inflater.inflate(R.layout.fragment... */

/*---------- Preparando os botões FAB | Fim  ----------*/


/*********** FAB com Mensagem | Ini  **********/

//O primeiro submenu ser tocado exibe um TOAST
FabSubmenu fsm = new FabSubmenu(fab, submenuFab, MainActivity.this);
fsm.fabMainTouch();
fsm.fabSubmenuTouchMessage(fabsub1,"Minha Localização");

/*********** FAB com Mensagem | Fim  **********/

/*********** FAB com Activity | Ini  **********/

//O segundo submenu ser tocado chama uma Activity
Intent i = new Intent(MainActivity.this, FaleConoscoActivity.class);
fsm.fabSubmenuTouchOpenActivity(fabsub2, i);

/*********** FAB com Activity | Fim  **********/

/*********** FAB com Fragment | Ini  **********/

//O terceiro submenu ser tocado chama um novo Fragament
NotificacoesFragment notif = new NotificacoesFragment();
FragmentManager managerNotif = getSupportFragmentManager();
fsm.fabSubmenuTouchOpenFragment(fabsub3, R.id.mContent, notif, managerNotif, "fragment_inicio");

/*********** FAB com Fragment | Fim  **********/

/* Setando a cor verde para o primeiro FAB Button */

//Pode ser usado para alterar a cor de fundo de qualquer FloatingActionButton
fsm.setFabBackgroundColor(fabsub1,"#1b7d83");

```
