class Car {
  // Required properties
  private seats: number;
  private engine: string;

  // Optional properties
  private brand?: string;
  private mileage?: number;
  private color?: string;

  public setSeats(seats: number) {
    this.seats = seats;
  }

  public setEngine(engine: string) {
    this.engine = engine;
  }

  public setBrand(brand: string) {
    this.brand = brand;
  }

  public setMileage(mileage: number) {
    this.mileage = mileage;
  }

  public setColor(color: string) {
    this.color = color;
  }
}

interface Builder {
  setSeats(seats: number): this;
  setEngine(engine: string): this;
  setBrand(brand: string): this;
  setMileage(mileage: number): this;
  setColor(color: string): this;
  build(): Car;
  reset(): void;
}

class CarBuilder implements Builder {
  private car: Car;

  constructor() {
    this.car = new Car();
  }

  public setSeats(seats: number): this {
    this.car.setSeats(seats);
    return this;
  }

  public setEngine(engine: string): this {
    this.car.setEngine(engine);
    return this;
  }

  public setBrand(brand: string): this {
    this.car.setBrand(brand);
    return this;
  }

  public setMileage(mileage: number): this {
    this.car.setMileage(mileage);
    return this;
  }

  public setColor(color: string): this {
    this.car.setColor(color);
    return this;
  }

  public build(): Car {
    const result = this.car;
    this.reset();
    return result;
  }

  public reset(): void {
    this.car = new Car();
  }
}

// Similarly we can create as many cars as we want with different set of properties
const car = new CarBuilder().setSeats(4).setEngine('V-12').build();
console.log(car);

const car2 = new CarBuilder()
  .setSeats(6)
  .setEngine('V-18')
  .setColor('blue')
  .setMileage(23.3)
  .build();
console.log(car2);

// We can also create a director class to create different types of cars

class Director {
  private builder: Builder;

  constructor(builder: Builder) {
    this.builder = builder;
  }

  public constructSportsCar(): Car {
    return this.builder.setSeats(2).setEngine('V-8').setColor('red').build();
  }

  public constructSUV(): Car {
    return this.builder.setSeats(4).setColor('black').build();
  }
}

const director = new Director(new CarBuilder());
const car3 = director.constructSportsCar();
const car4 = director.constructSUV();

console.log(car3);
console.log(car4);
