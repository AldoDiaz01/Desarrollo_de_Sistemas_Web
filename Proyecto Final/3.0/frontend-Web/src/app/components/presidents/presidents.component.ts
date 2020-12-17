import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Partido } from 'src/app/models/political';
import { Presidente } from 'src/app/models/president';
import { PoliticalDataService } from 'src/app/services/political.data.service';
import { PresidenteDataService } from 'src/app/services/president.data.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-presidents',
  templateUrl: './presidents.component.html',
  styleUrls: ['./presidents.component.css']
})
export class PresidentsComponent implements OnInit {

  presidents: Presidente[];
  cols: any[];
  items: MenuItem[];
  displaySaveDialog: boolean = false;
  selectedPresident: Presidente;
  president: Presidente;
  politicals: Partido[];
  itemsNavbar: MenuItem[];


  constructor(private politicalService: PoliticalDataService ,private router: Router ,private presidentService: PresidenteDataService, private messageService: MessageService, private confirmService: ConfirmationService) { }

  ngOnInit(): void {
    environment.token = localStorage.getItem('token');
    this.president = new Presidente();
    this.presidents = new Array<Presidente>();
    this.politicals = new Array<Partido>();
    this.president.esDios = false;
    this.getAll();
    this.getPartidos();
    this.cols = [
      {field: "id", header: "ID"},
      {field: "nombre", header: "Nombre"},
      {field: "edad", header: "Edad"},
      {field: "puestoRobado", header: "Puesto robado"},
      {field: "calidadGobierno", header: "Calidad de gobierno"},
      {field: "esDios", header: "¿Es Dios?"},
      {field: "partido.nombre", header: "Partido"}
    ];

    this.items = [
      {
        label: "Nuevo",
        icon: 'pi pi-fw pi-plus',
        command: () => this.showSaveDialog(false)
      },
      {
        label: "Editar",
        icon: 'pi pi-fw pi-pencil',
        command: () => this.showSaveDialog(true)
      },
      {
        label: "Eliminar",
        icon: 'pi pi-fw pi-times',
        command: () => this.delete()
      }
    ]

    this.itemsNavbar = [
      {
          label: 'Presidentes',
          icon: 'pi pi-fw pi-users',
          command: () => this.navegarPresidentes()
      },
      {
          label: 'Partidos',
          icon: 'pi pi-fw pi-dollar',
          command: () => this.navegarPartidos()
      },
      {
        label: 'Cerrar sesión',
        icon: 'pi pi-fw pi-times-circle',
        command: () => this.cerrarSesion()
      }
  ];
  }

  getAll() {
    this.presidentService.getAll().subscribe(
      (result: any) => {
        let presidentes: Presidente[] = [];
        for (let i = 0; i < result.length ; i++) {
          const presidente = result[i] as Presidente;
          presidentes.push(presidente);
        }
        this.presidents = presidentes;
      },
      error => {
        console.log(error);
      }
    );
  }

  getPartidos() {
    this.politicalService.getAll().subscribe(
      (result: any) => {
        let partidos: Partido[] = [];
        for (let i = 0; i < result.length ; i++) {
          const partido = result[i] as Partido;
          partidos.push(partido);
        }
        this.politicals = partidos;
      },
      error => {
        console.log(error);
      }
    );
  }

  showSaveDialog(editar: boolean) {
    if(editar) {
      if(this.selectedPresident != null && this.selectedPresident.id != null){
        this.president = this.selectedPresident;
      } else {
        this.messageService.add({severity: 'warn', summary: 'Advertencia', detail: 'Por favor seleccione un registro'})
        return;
      }
    } else {
      this.president = new Presidente();
    }
    this.displaySaveDialog = true;
  }

  save() {
    this.presidentService.create(this.president).subscribe(
      (result: any) => {
        this.messageService.add({severity:'success', summary:'Resultado', detail:'Se guardo el presidente correctamente'});
        this.displaySaveDialog = false;
        this.getAll();
      },
      error => {
        console.log(error);
      }
    )
  }

  delete() {
    if(this.selectedPresident == null) {
      this.messageService.add({severity: 'warn', summary: 'Advertencia', detail: 'Por favor seleccione un registro'});
    } else {
      this.confirmService.confirm({
          message: "¿Está seguro que desea eliminar el registro?",
          accept: () => {
            this.presidentService.delete(this.selectedPresident.id).subscribe(
              (result: any) => {
                this.messageService.add({
                  severity: 'success',
                  summary: "Resultado",
                  detail: "Se elimino el presidente  " + this.selectedPresident.nombre + " correctamente"
                });
                this.getAll();
              }
            )
          }
        }
      )}
  }
  
  navegarPartidos(){
    this.router.navigate(['/political']);
  }

  navegarPresidentes(){
    this.router.navigate(['/presidents']);
  }

  cerrarSesion(){
    this.router.navigate(['/']);
    localStorage.removeItem('token');
  }

  

}
