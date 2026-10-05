void main() {

    Scanner scanner = new Scanner(System.in);
    List<ENVIO> lstEnvios = new ArrayList<>();
    int opcion = 0;

    do {
        System.out.println("==========================================");
        System.out.println("   SISTEMA DE GESTION DE ENVIOS ");
        System.out.println("==========================================");
        System.out.println("1. Registrar envío terrestre. ");
        System.out.println("2. Registrar envío aéreo. ");
        System.out.println("3. Mostrar todos los envíos. ");
        System.out.println("4. Buscar envío por código. ");
        System.out.println("5. Mostrar el envío más costoso. ");
        System.out.println("6. Calcular total recaudado.");
        System.out.println("7. Mostrar cantidad de envíos por tipo. ");
        System.out.println("8. Salir. ");

        if (scanner.hasNextInt()) {
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("REGISTRAR ENVIO TERRESTRE");
                    System.out.println("Ingrese Codigo");
                    String codT = scanner.nextLine();
                    System.out.print("Ingrese destino: ");
                    String destT = scanner.nextLine();
                    System.out.print("Ingrese peso (kg): ");
                    double pesoT = scanner.nextDouble();
                    System.out.print("Ingrese distancia (km): ");
                    double distT = scanner.nextDouble();
                    scanner.nextLine();

                    ENVIO envioT = new EnvioTerrestre(codT, destT, pesoT, distT);
                    lstEnvios.add(envioT);
                    System.out.println("¡Envío terrestre registrado con éxito!");
                    break;
                case 2:
                    System.out.println("--- REGISTRAR ENVÍO AÉREO ---");
                    System.out.print("Ingrese código: ");
                    String codA = scanner.nextLine();
                    System.out.print("Ingrese destino: ");
                    String destA = scanner.nextLine();
                    System.out.print("Ingrese peso (kg): ");
                    double pesoA = scanner.nextDouble();
                    System.out.print("Ingrese distancia (km): ");
                    double distA = scanner.nextDouble();
                    scanner.nextLine();

                    ENVIO envioA = new EnvioAereo(codA, destA, pesoA, distA);
                    lstEnvios.add(envioA);
                    System.out.println("¡Envío aéreo registrado con éxito!");
                    break;

                case 3:
                    System.out.println("--- LISTA DE TODOS LOS ENVÍOS ---");
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados en el sistema.");
                    } else {
                        for (ENVIO e : lstEnvios) {
                            e.MonstrarInformacion();
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;

                case 4: // Buscar envío por código
                    System.out.println("--- BUSCAR ENVÍO POR CÓDIGO ---");
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        System.out.print("Ingrese el código a buscar: ");
                        String codigoBuscado = scanner.nextLine();
                        boolean encontrado = false;

                        for (ENVIO e : lstEnvios) {
                            // Comparamos ignorando mayúsculas/minúsculas
                            if (e.Codigo.equalsIgnoreCase(codigoBuscado)) {
                                System.out.println("¡Envío encontrado!");
                                e.MonstrarInformacion();
                                encontrado = true;
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("No se encontró ningún envío con el código: " + codigoBuscado);
                        }
                    }
                    break;

                case 5: // Mostrar el envío más costoso
                    System.out.println("\n--- ENVÍO MÁS COSTOSO ---");
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        ENVIO masCostoso = lstEnvios.get(0);
                        for (int i = 1; i < lstEnvios.size(); i++) {
                            if (lstEnvios.get(i).Calcularcosto() > masCostoso.Calcularcosto()) {
                                masCostoso = lstEnvios.get(i);
                            }
                        }
                        System.out.println("El envío con mayor costo es:");
                        masCostoso.MonstrarInformacion();
                    }
                    break;

                case 6: // Calcular total recaudado
                    System.out.println("--- TOTAL RECAUDADO ---");
                    if (lstEnvios.isEmpty()) {
                        System.out.println("No hay envíos registrados.");
                    } else {
                        double totalRecaudado = 0;
                        for (ENVIO e : lstEnvios) {
                            totalRecaudado += e.Calcularcosto();
                        }
                        System.out.println("El total recaudado por todos los envíos es: $" + totalRecaudado);
                    }
                    break;

                case 7: // Mostrar cantidad de envíos por tipo
                    System.out.println("--- CANTIDAD DE ENVÍOS POR TIPO ---");
                    int contadorTerrestres = 0;
                    int contadorAereos = 0;

                    for (ENVIO e : lstEnvios) {
                        if (e instanceof EnvioTerrestre) {
                            contadorTerrestres++;
                        } else if (e instanceof EnvioAereo) {
                            contadorAereos++;
                        }
                    }

                    System.out.println("Cantidad de Envíos Terrestres: " + contadorTerrestres);
                    System.out.println("Cantidad de Envíos Aéreos: " + contadorAereos);
                    System.out.println("Total de envíos: " + lstEnvios.size());
                    break;

                case 8:
                    System.out.println("Saliendo del sistema de envíos. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija un número entre 1 y 8.");
            }

        } else {
            System.out.println("Error: Debe ingresar un número válido.");
            scanner.next();
        }
    }while (opcion != 8);
    scanner.close();
}