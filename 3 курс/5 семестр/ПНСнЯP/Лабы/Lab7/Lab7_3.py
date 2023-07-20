from keras.datasets import mnist
from tensorflow.keras.utils import to_categorical
from keras import Sequential
from keras.layers import Dense, Conv2D, Flatten, MaxPooling2D

# Загружаем данные x_train и x_test содержат двухмерный массив с изображение цифр
# x_test, y_test массив с проверочными данными сети.
(x_train, y_train), (x_test, y_test) = mnist.load_data()
# Трансформируем из двухмерного массива в трех мерный(28х28х1 канал)
x_train = x_train.reshape(60000, 28, 28, 1)
x_test = x_test.reshape(10000, 28, 28, 1)

y_train = to_categorical(y_train)
y_test = to_categorical(y_test)

model = Sequential()
# Conv2D (число фильтро, размер ядра, ф-ция активации, формат входных данных с одним цветовым каналом)
model.add(Conv2D(64, kernel_size=3, activation='relu', input_shape=(28, 28, 1)))
# укрупняет масштаб полученных признаков
model.add(MaxPooling2D())
model.add(Conv2D(128, kernel_size=3, activation='relu'))
# вытягивает всё в один вектор
model.add(Flatten())
model.add(Dense(10, activation='softmax'))
model.compile(optimizer='adam', loss='mean_squared_error', metrics=['accuracy'])
history = model.fit(x_train, y_train, validation_data=(x_test, y_test), epochs=15)

model.evaluate(x_test,y_test)

# Генерируем описание модели в формате json
model_json = model.to_json()
# Записываем модель в файл
json_file = open("mnist_model.json", "w")
json_file.write(model_json)
json_file.close()

model.save_weights("mnist_model.h5")

print("Сохранили Model")





