import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ConfirmationService, MenuItem, MessageService } from 'primeng/api';
import { Partido } from 'src/app/models/political';
import { PoliticalDataService } from 'src/app/services/political.data.service';
import { environment } from 'src/environments/environment';
@Component({
  selector: 'app-political.parties',
  templateUrl: './political.parties.component.html',
  styleUrls: ['./political.parties.component.css']
})
export class PoliticalPartiesComponent implements OnInit {

  politicals: Partido[];
  cols: any[];
  items: MenuItem[];
  displaySaveDialog: boolean = false;
  selectedPartido: Partido;
  political: Partido;
  itemsNavbar: MenuItem[];

  constructor(private router: Router, private politicalService: PoliticalDataService, private messageService: MessageService, private confirmService: ConfirmationService) { }

  ngOnInit(): void {
    environment.token = localStorage.getItem('token');
    this.political = new Partido();
    this.politicals = new Array<Partido>();
    this.getAll();
    this.cols = [
      { field: "id", header: "ID" },
      { field: "nombre", header: "Nombre" },
      { field: "antiguedad", header: "Antigüedad" },
      { field: "nombreCompleto", header: "Nombre completo" }
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
    ]
  }

  getAll() {
    this.politicalService.getAll().subscribe(
      (result: any) => {
        let partidos: Partido[] = [];
        for (let i = 0; i < result.length; i++) {
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
    if (editar) {
      if (this.selectedPartido != null && this.selectedPartido.id != null) {
        this.political = this.selectedPartido;
      } else {
        this.messageService.add({ severity: 'warn', summary: 'Advertencia', detail: 'Por favor seleccione un registro' })
        return;
      }
    } else {
      this.political = new Partido();
    }
    this.displaySaveDialog = true;
  }

  save() {
    this.politicalService.create(this.political).subscribe(
      (result: any) => {
        this.messageService.add({ severity: 'success', summary: 'Resultado', detail: 'Se guardo el partido correctamente' });
        this.displaySaveDialog = false;
        this.getAll();
      },
      error => {
        console.log(error);
      }
    )
  }

  delete() {
    if (this.selectedPartido == null) {
      this.messageService.add({ severity: 'warn', summary: 'Advertencia', detail: 'Por favor seleccione un registro' });
    } else {
      this.confirmService.confirm({
        message: "¿Está seguro que desea eliminar el registro?",
        accept: () => {
          this.politicalService.delete(this.selectedPartido.id).subscribe(
            (result: any) => {
              this.messageService.add({
                severity: 'success',
                summary: "Resultado",
                detail: "Se elimino el partido  " + this.selectedPartido.nombre + " correctamente"
              });
              this.getAll();
            }
          )
        }
      }
      )
    }
  }

  navegarPartidos() {
    this.router.navigate(['/political']);
  }

  navegarPresidentes() {
    this.router.navigate(['/presidents']);
  }

  cerrarSesion(){
    this.router.navigate(['/']);
    localStorage.removeItem('token');
  }


}
