package com.marsrover;

import com.marsrover.domain.FaceDirection;
import com.marsrover.domain.Mars;
import com.marsrover.domain.MoveType;
import com.marsrover.domain.Rover;
import com.marsrover.service.RoverService;
import com.marsrover.service.impl.RoverServiceImpl;
import com.marsrover.util.ValidationUtil;
import com.marsrover.util.ValidationUtilDev;

import java.util.Scanner;

public class Nasa {

    public static void main(String[] args) {
        Nasa nasa = new Nasa();
        Scanner scanner = new Scanner(System.in);

        nasa.startProcess(scanner);
    }

    public void startProcess(Scanner scanner) {
        System.out.println("Please enter research field size like '5 5' :");
        String[] numbers = scanner.nextLine().split(" ");

        ValidationUtil validationUtil = new ValidationUtilDev();
        int xSize = Integer.parseInt(numbers[0]);
        int ySize = Integer.parseInt(numbers[1]);
        validationUtil.checkNegativeValues(xSize, ySize);
        Mars mars = new Mars(xSize, ySize);

        System.out.println("Type q to quit");

        while (true) {
            System.out.println("Please enter first coordinates and face direction like '1 2 N' :");

            String firstCoordinate = scanner.nextLine();

            if (firstCoordinate.equals("")) break;

            String[] roverInitParams = firstCoordinate.toUpperCase().split(" ");

            int xCoordinate = Integer.parseInt(roverInitParams[0]);
            int yCoordinate = Integer.parseInt(roverInitParams[1]);
            FaceDirection faceDirection = FaceDirection.valueOf(roverInitParams[2]);
            validationUtil.checkNegativeValues(xCoordinate, yCoordinate);
            validationUtil.checkMaxValues(xCoordinate, yCoordinate, mars);

            Rover rover = new Rover(xCoordinate, yCoordinate, faceDirection);

            System.out.println("Please enter the command set consisting of the letters 'L', 'M' and 'R',like 'LMLMLMLMM' :");
            String commands = scanner.nextLine().toUpperCase();

            RoverService roverService = new RoverServiceImpl();

            for (char command : commands.toCharArray()) {
                switch (MoveType.valueOf(String.valueOf(command))) {
                    case L:
                        roverService.changeDirection(rover, MoveType.L);
                        break;
                    case R:
                        roverService.changeDirection(rover, MoveType.R);
                        break;
                    case M:
                        if (roverService.canMove(rover, mars)) roverService.move(rover);
                        break;
                    default:
                        System.exit(1);
                }
            }
            System.out.println(rover.getxCoordinate() + " " + rover.getYCoordinate() + " " + rover.getFaceDirection().name());
        }
    }

}
