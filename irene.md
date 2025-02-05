# Uso de Git

Abrir la terminal con `cmd`.

Para descargar un repositorio que nunca has descargado, abre la terminal en la carpeta que quieras y escribe:

```
git clone (enlace del repositorio)
```

Para descargar cambios del repositorio ya creado, abre el `cmd` en esa carpeta y escribe:

```
git pull
```

Si hay cambios se descargarán y si no te avisará que ya tienes todo.

Si tienes un repositorio propio y quieres subir cambios al github:

```
git status
git add .
git commit -m "mensaje"
git push origin main
```

`Nunca hagas esto para un repositorio que no sea tuyo.`